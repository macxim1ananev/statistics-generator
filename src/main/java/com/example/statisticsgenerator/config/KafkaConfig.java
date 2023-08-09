package com.example.statisticsgenerator.config;

import com.example.statisticsgenerator.core.service.error.KafkaErrorHandler;
import com.example.statisticsgenerator.core.service.events.UserAnswerEvent;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class KafkaConfig {
    @Value("${spring.kafka.bootstrap-server}")
    private String kafkaServer;
    @Value("${spring.kafka.consumer.group-id}")
    private String consumerGroupId;

    @Bean
    public Map<String, Object> consumerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServer);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, consumerGroupId);
        props.put(JsonDeserializer.VALUE_DEFAULT_TYPE, UserAnswerEvent.class);
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        return props;
    }


    @Bean
    public ConsumerFactory<String, UserAnswerEvent> consumerFactory() {
        JsonDeserializer<UserAnswerEvent> thingDeserializer = new JsonDeserializer<>(UserAnswerEvent.class);
        return new DefaultKafkaConsumerFactory<>(consumerConfigs(), new StringDeserializer(), thingDeserializer);
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, UserAnswerEvent>> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, UserAnswerEvent> factory = new ConcurrentKafkaListenerContainerFactory();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
