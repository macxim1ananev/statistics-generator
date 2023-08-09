package com.example.statisticsgenerator.infrastructure.input.consumers;

import com.example.statisticsgenerator.core.service.command_bus.CommandBus;
import com.example.statisticsgenerator.core.service.events.UserAnswerEvent;
import com.example.statisticsgenerator.core.statistics.commands.GenerateStatisticsCommand;
import com.example.statisticsgenerator.core.statistics.interactors.GenerateStatisticsInteractor;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumer {
    private final CommandBus commandBus;
    private final ObjectMapper mapper;

    @KafkaListener(topics = "user-answer-topic", groupId = "statistics-generator-consumer")
    public void listenTopic(ConsumerRecord<String, UserAnswerEvent> message) {
        log.info(String.format("Getting message: %s", message));
        commandBus.execute(GenerateStatisticsCommand
                .builder()
                .userAnswers(message.value().getUserAnswers())
                .user(message.value().getUser())
                .build());
    }
}