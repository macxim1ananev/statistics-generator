package com.example.statisticsgenerator.core.service.interfaces;

import com.example.statisticsgenerator.core.statistics.entities.UserAnswer;

import java.util.List;

public interface UserAnswers {
    UserAnswer put(UserAnswer userAnswer);

    List<UserAnswer> getAllByFeedbackId(Long feedbackId);
}
