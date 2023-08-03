package com.example.statisticsgenerator.infrastructure.output.producers.kafka;

import com.example.statisticsgenerator.core.service.events.BaseEvent;
import com.example.statisticsgenerator.core.service.events.UserAnswerEvent;
import com.example.statisticsgenerator.core.service.interfaces.KafkaGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaGatewayImpl implements KafkaGateway {
    @Autowired
    private KafkaTemplate<String, BaseEvent> kafkaTemplate;

    @Value("${spring.kafka.topics.user-answer.name}")
    private String userAnswerTopic;

    @Value("${spring.kafka.topics.user-answer.key}")
    private String userAnswerTopicKey;

}
