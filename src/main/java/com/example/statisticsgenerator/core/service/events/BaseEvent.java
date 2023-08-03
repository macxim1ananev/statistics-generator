package com.example.statisticsgenerator.core.service.events;

import lombok.Data;

import java.util.UUID;

@Data
public class BaseEvent {
    private String messageId = UUID.randomUUID().toString();
}
