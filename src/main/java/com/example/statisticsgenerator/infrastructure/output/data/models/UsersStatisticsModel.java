package com.example.statisticsgenerator.infrastructure.output.data.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user_statistics", schema = "public")
public class UsersStatisticsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private UserModel user;
    private Integer totalOneToOneCount;
    private Integer totalQuestionCount;
    private Integer totalPoint;
}
