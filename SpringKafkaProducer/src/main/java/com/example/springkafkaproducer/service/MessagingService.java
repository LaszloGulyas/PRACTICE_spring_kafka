package com.example.springkafkaproducer.service;

import com.example.springkafkaproducer.producer.KafkaMessageProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class MessagingService {

    private static final Logger LOG = LoggerFactory.getLogger(MessagingService.class);
    private static final String TOPIC_NAME = "hello-world";

    private final KafkaMessageProducer kafkaMessageProducer;

    public MessagingService(@Autowired KafkaMessageProducer kafkaMessageProducer) {
        this.kafkaMessageProducer = kafkaMessageProducer;
    }

    @Scheduled(fixedRate = 5000)
    public void sendAutoMessage() {
        String messageValue = String.valueOf(Instant.now().toEpochMilli());
        LOG.info("!!!!! Sending auto message to Kafka:{}", messageValue);
        kafkaMessageProducer.sendMessage(TOPIC_NAME, "Message time: " + messageValue);
    }
}
