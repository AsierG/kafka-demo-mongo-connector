package com.asierg.kafka.consumer;

import com.asierg.kafka.dto.MongoDataDTO;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class MongoListener {

    private static final Logger LOG = LoggerFactory.getLogger(MongoListener.class);

    @KafkaListener(topics = "${app.topic.example}")
    public void receive(@Payload MongoDataDTO data,
                        @Headers MessageHeaders headers) {
        LOG.info("received data='{}'", data);
        Document document = Document.parse(data.getPayload());
        LOG.info("received payload='{}'", document);
        headers.keySet().forEach(key -> LOG.info("{}: {}", key, headers.get(key)));
    }

}
