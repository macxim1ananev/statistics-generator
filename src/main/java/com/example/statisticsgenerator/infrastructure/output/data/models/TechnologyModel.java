package com.example.statisticsgenerator.infrastructure.output.data.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "technologies", schema = "public")
public class TechnologyModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
