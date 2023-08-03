package com.example.statisticsgenerator.infrastructure.output.data.models;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "users", schema = "public")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String name;
    private String surName;
    private String status;
    @ManyToOne
    private UserRoleModel role;
}
