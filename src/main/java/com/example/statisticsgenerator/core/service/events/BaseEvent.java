package com.example.statisticsgenerator.core.service.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseEvent {
    private String messageId = UUID.randomUUID().toString();
}
