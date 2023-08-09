package com.example.statisticsgenerator.core.service.events;

import com.example.statisticsgenerator.core.statistics.entities.UserAnswer;
import com.example.statisticsgenerator.core.user.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserAnswerEvent extends BaseEvent {
    public UserAnswerEvent(List<UserAnswer> entityList) {
        userAnswers = entityList;
    }

    private List<UserAnswer> userAnswers;
    private User user;
}
