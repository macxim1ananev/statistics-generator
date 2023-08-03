package com.example.statisticsgenerator.infrastructure.output.data.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user_technology_statistics", schema = "public")
public class UserTechnologyStatisticsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private UsersStatisticsModel userStatistics;
    @OneToOne
    private TechnologyModel technology;
    private Integer totalPoint;
    private Integer questionCount;
}
