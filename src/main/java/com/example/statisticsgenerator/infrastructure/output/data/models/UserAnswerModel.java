package com.example.statisticsgenerator.infrastructure.output.data.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user_answer", schema = "public")
public class UserAnswerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long feedbackId;
    @OneToOne
    private QuestionModel question;
    private Integer responseLevel;
    private String comment;
}
