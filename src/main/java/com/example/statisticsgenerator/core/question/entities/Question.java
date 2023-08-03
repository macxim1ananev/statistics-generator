package com.example.statisticsgenerator.core.question.entities;

import com.example.statisticsgenerator.core.technology.entities.Technology;
import lombok.Data;

@Data
public class Question {
    private Long id;
    private String question;
    private String answer;
    private Technology technology;
    private Long userId;
}
