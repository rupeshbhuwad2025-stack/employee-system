package com.lms.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.lms.kafka.consumer.KafkaConsumer;

@Service
public class KafkaProducer {
	
		private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

	 	private final KafkaTemplate<String, String> kafkaTemplate;

	    // Spring Boot auto-injects the KafkaTemplate configured in properties
	    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
	        this.kafkaTemplate = kafkaTemplate;
	    }

	    public void sendMessage(String message) {
	    	logger.info(String.format("#### -> Producing message -> %s", message));
	        this.kafkaTemplate.send("lms-topic", message);
	    }
}
