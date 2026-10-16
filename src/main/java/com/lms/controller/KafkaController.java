package com.lms.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lms.kafka.consumer.KafkaConsumer;
import com.lms.kafka.producer.KafkaProducer;

@RestController
public class KafkaController {
	
	private final KafkaProducer producer;

    public KafkaController(KafkaProducer producer, KafkaConsumer consumer) {
        this.producer = producer;
    }

    @PostMapping("/publish")
    public String sendMessageToKafkaTopic(@RequestBody String message) {
        this.producer.sendMessage(message);
        return "Message sent to the Kafka Topic Successfully!";
    }
    

}
