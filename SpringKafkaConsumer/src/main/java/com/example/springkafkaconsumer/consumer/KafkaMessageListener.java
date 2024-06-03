package com.example.springkafkaconsumer.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessageListener {

    private static final Logger LOG = LoggerFactory.getLogger(KafkaMessageListener.class);
    private static final String TOPIC_NAME = "hello-world";

    @KafkaListener(topics = TOPIC_NAME)
    public void listen(String message) throws InterruptedException {
        LOG.info("Received message: {}", message);
        Thread.sleep(2000);
    }
}
