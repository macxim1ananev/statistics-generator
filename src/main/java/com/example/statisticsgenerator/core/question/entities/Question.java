package com.example.statisticsgenerator.core.question.entities;

import com.example.statisticsgenerator.core.technology.entities.Technology;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    private Long id;
    private String question;
    private String answer;
    private Technology technology;
    private Long userId;
}
