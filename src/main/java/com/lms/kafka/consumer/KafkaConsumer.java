package com.lms.kafka.consumer;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class KafkaConsumer {
	private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

	@KafkaListener(topics = "lms-topic", groupId = "my-new-group-v2")
    public void consume(String message) {
		 logger.info("⭐⭐ SUCCESS: Message consumed -> {}", message);
    }
}
