package com.example.statisticsgenerator.infrastructure.output.data.adapters;

import com.example.statisticsgenerator.core.service.interfaces.UserAnswers;
import com.example.statisticsgenerator.core.statistics.entities.UserAnswer;
import com.example.statisticsgenerator.infrastructure.output.data.mappers.UserAnswerModelMapper;
import com.example.statisticsgenerator.infrastructure.output.data.repositories.UserAnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserAnswerAdapter implements UserAnswers {
    private final UserAnswerRepository repository;
    private final UserAnswerModelMapper mapper;

    @Override
    public UserAnswer put(UserAnswer userAnswer) {
        var model = mapper.toModel(userAnswer);
        return mapper.toEntity(repository.save(model));
    }

    @Override
    public List<UserAnswer> getAllByFeedbackId(Long feedbackId) {
        var modelList = repository.getAllByFeedbackId(feedbackId);
        return modelList.stream().map(mapper::toEntity).collect(Collectors.toList());
    }
}
