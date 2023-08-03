package com.example.statisticsgenerator.core.statistics.entities;

import com.example.statisticsgenerator.core.question.entities.Question;
import lombok.Data;

@Data
public class UserAnswer {
    private Question question;
    private Long feedbackId;
    private Integer responseLevel;
    private String comment;
}
