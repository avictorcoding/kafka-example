package com.anuj.springbootkafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.anuj.springbootkafka.payload.User;

@Service
public class KafkaConsumer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
	
	@KafkaListener(topics = "employeeStatus", groupId = "myGroup")
	public void consume(String message) {
		LOGGER.info("message recieved > "+message);
		
	}
	
	@KafkaListener(topics = "user_json", groupId = "myGroup")
	public void consume(User user) {
		LOGGER.info(String.format("user recieved > %s ",user.toString()));
		
	}


}
