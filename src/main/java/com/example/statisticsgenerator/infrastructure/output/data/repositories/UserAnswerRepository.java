package com.example.statisticsgenerator.infrastructure.output.data.repositories;

import com.example.statisticsgenerator.infrastructure.output.data.models.UserAnswerModel;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserAnswerRepository extends JpaRepository<UserAnswerModel, Long> {
    @EntityGraph(attributePaths = {"question", "question.technology"})
    List<UserAnswerModel> getAllByFeedbackId(Long feedbackId);
}
