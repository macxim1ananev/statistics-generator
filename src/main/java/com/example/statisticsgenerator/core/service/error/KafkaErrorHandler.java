package com.example.statisticsgenerator.core.service.error;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.errors.RecordDeserializationException;
import org.springframework.kafka.listener.CommonErrorHandler;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaErrorHandler implements CommonErrorHandler {

    @Override
    public void handleOtherException(Exception thrownException, Consumer<?, ?> consumer,
                                     MessageListenerContainer container, boolean batchListener) {
        //для обработки исключений, которые возникают за пределами области обработки
        // записей (например, ошибки потребителя).
        //Ошибки десериализации ловим здесь
        manageException(thrownException, consumer);
    }

    @Override
    public void handleRecord(Exception thrownException, ConsumerRecord<?, ?> record,
                             Consumer<?, ?> consumer, MessageListenerContainer container) {
        //здесь обрабатываем ошибки обработки записи
        log.error(String.format("Exception: %s Container: %s", thrownException.getMessage(), container));
    }

    private void manageException(Exception ex, Consumer<?, ?> consumer) {
        //здесь мы пропускаем сообщение, ключ которого не смогли прочитать и аккуратно логируем
        log.error("Error: " + ex.getMessage());
        if (ex instanceof RecordDeserializationException) {
            RecordDeserializationException rde = (RecordDeserializationException) ex;
            consumer.seek(rde.topicPartition(), rde.offset() + 1L);
            consumer.commitSync();
        } else {
            log.error(String.format("Exception: %s. Consumer %s",ex.getMessage(),consumer));
        }
    }
}