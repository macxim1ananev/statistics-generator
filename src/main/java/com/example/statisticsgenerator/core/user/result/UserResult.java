package com.example.statisticsgenerator.core.user.result;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserResult {
    Long id;
    String email;
    String password;
    String name;
    String surName;
    String status;
}
