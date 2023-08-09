package com.example.statisticsgenerator.core.statistics.interactors;

import com.example.statisticsgenerator.core.service.common.Interactor;
import com.example.statisticsgenerator.core.service.error.ServiceException;
import com.example.statisticsgenerator.core.service.interfaces.Technologies;
import com.example.statisticsgenerator.core.service.interfaces.Users;
import com.example.statisticsgenerator.core.service.interfaces.UsersStatistics;
import com.example.statisticsgenerator.core.service.interfaces.UsersTechnologyStatistics;
import com.example.statisticsgenerator.core.statistics.commands.GenerateStatisticsCommand;
import com.example.statisticsgenerator.core.statistics.entities.UserAnswer;
import com.example.statisticsgenerator.core.statistics.entities.UserStatistics;
import com.example.statisticsgenerator.core.statistics.entities.UserTechnologyStatistics;
import com.example.statisticsgenerator.core.statistics.results.FullUserStatisticsResult;
import com.example.statisticsgenerator.core.user.entities.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class GenerateStatisticsInteractor implements Interactor<GenerateStatisticsCommand, FullUserStatisticsResult> {
    private final Users users;
    private final UsersStatistics usersStatistics;
    private final UsersTechnologyStatistics usersTechnologyStatistics;
    private final Technologies technologies;

    @Override
    public FullUserStatisticsResult execute(GenerateStatisticsCommand command) {
        log.info("Executing command {}", command);

        var recipient = users.get(command.getUser().getId())
                .orElseThrow(() -> new ServiceException(ServiceException.Exception.USER_NOT_FOUND, command.getUser().getId()));
        var userStatistics = saveStatistics(updateStatistics(recipient, command.getUserAnswers()));
        saveUserTechnologyStatistics(updateUserTechnologyStatistics(command.getUserAnswers(), userStatistics));
        return null;
    }

    private void saveUserTechnologyStatistics(List<UserTechnologyStatistics> statistics) {
        statistics.forEach(usersTechnologyStatistics::save);
    }

    private UserStatistics saveStatistics(UserStatistics statistics) {
        return usersStatistics.save(statistics);

    }

    private UserStatistics updateStatistics(User user, List<UserAnswer> userAnswers) {
        var userStatistics = usersStatistics.get(user.getId());

        if (userStatistics.isEmpty()) {
            var newUserStatistics = new UserStatistics();
            newUserStatistics.setUser(user);
            newUserStatistics.setTotalOneToOneCount(1);
            newUserStatistics.setTotalQuestionCount(userAnswers.size());
            newUserStatistics.setTotalPoint(getTotalPoint(userAnswers));
            return newUserStatistics;
        } else {
            var currentUserStatistics = userStatistics.get();
            currentUserStatistics.incrementOneToOneCount();
            currentUserStatistics.incrementTotalQuestionCount(userAnswers.size());
            currentUserStatistics.plusTotalPoint(getTotalPoint(userAnswers));
            return currentUserStatistics;
        }
    }

    private Integer getTotalPoint(List<UserAnswer> userAnswers) {
        Integer totalPoint = 0;
        for (UserAnswer ua : userAnswers) {
            totalPoint += ua.getResponseLevel();
        }
        return totalPoint;
    }

    private List<UserTechnologyStatistics> updateUserTechnologyStatistics(List<UserAnswer> userAnswers, UserStatistics userStatistics) {
        var statistics = usersTechnologyStatistics.getById(userStatistics.getId());

        if (statistics.isEmpty()) {
            Map<Long, UserTechnologyStatistics> map = new HashMap<>();
            for (UserAnswer ua : userAnswers) {
                var technologyId = ua.getQuestion().getTechnology().getId();
                var uts = map.get(technologyId);
                if (uts == null) {
                    uts = new UserTechnologyStatistics();
                    uts.setUserStatistics(userStatistics);
                    uts.setTechnology(technologies.get(technologyId).orElseThrow(
                            () -> new ServiceException(ServiceException.Exception.TECHNOLOGY_NOT_FOUND, technologyId)));
                    uts.incrementQuestionCount();
                    uts.plusTotalPoint(ua.getResponseLevel());
                    map.put(technologyId, uts);
                } else {
                    uts.incrementQuestionCount();
                    uts.plusTotalPoint(ua.getResponseLevel());
                }
            }
            return map.values().stream().toList();
        } else {
            Map<Long, UserTechnologyStatistics> map = statistics
                    .stream()
                    .collect(Collectors.toMap(
                            ust -> ust.getTechnology().getId(), Function.identity()));

            for (UserAnswer ua : userAnswers) {
                var technologyId = ua.getQuestion().getTechnology().getId();
                var uts = map.get(technologyId);
                if (uts != null) {
                    uts.incrementQuestionCount();
                    uts.plusTotalPoint(ua.getResponseLevel());
                } else {
                    var newUts = new UserTechnologyStatistics();
                    newUts.setUserStatistics(userStatistics);
                    newUts.setQuestionCount(1);
                    newUts.setTechnology(technologies.get(technologyId).orElseThrow(
                            () -> new ServiceException(ServiceException.Exception.TECHNOLOGY_NOT_FOUND, technologyId)));
                    newUts.setTotalPoint(ua.getResponseLevel());
                    map.put(newUts.getTechnology().getId(), newUts);
                }
            }
            return map.values().stream().toList();
        }
    }
}
