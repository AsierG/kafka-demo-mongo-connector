package com.asierg.kafka.producer;

import com.asierg.kafka.dto.MongoDataDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class Sender {

    private final KafkaTemplate<String, MongoDataDTO> kafkaTemplate;
    private static final Logger LOG = LoggerFactory.getLogger(Sender.class);

    @Value("${app.topic.example}")
    private String topic;

    public Sender(KafkaTemplate<String, MongoDataDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(MongoDataDTO data) {
        LOG.info("sending data='{}' to topic='{}'", data, topic);

        Message<MongoDataDTO> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, topic)
                .build();

        kafkaTemplate.send(message);
    }
}
