package com.example.statisticsgenerator.infrastructure.input.consumers;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "user-answer-topic")
    public void listenTopic(ConsumerRecord<String, String> record) {

        log.info(String.format("Getting message: %s", record.value()));

    }
}
