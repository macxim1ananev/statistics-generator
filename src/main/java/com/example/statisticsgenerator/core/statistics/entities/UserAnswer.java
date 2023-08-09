package com.example.statisticsgenerator.core.statistics.entities;

import com.example.statisticsgenerator.core.question.entities.Question;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserAnswer {
    private Question question;
    private Long feedbackId;
    private Integer responseLevel;
    private String comment;
}
