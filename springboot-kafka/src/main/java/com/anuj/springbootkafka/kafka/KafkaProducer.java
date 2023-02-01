package com.anuj.springbootkafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.anuj.springbootkafka.payload.User;

@Service
public class KafkaProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

	private KafkaTemplate<String, String> kafkaTemplate;

	@Autowired
	private KafkaTemplate<String, User> kafkaJsonTemplate;

	public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage(String message) {
		// LOGGER.info(String.format("Message sent %s", message));
		kafkaTemplate.send("employeeStatus", message);

	}

	public void sendMessage_Json(User user) {
		LOGGER.info(String.format("Message sent %s", user.toString()));

		Message<User> message = MessageBuilder.withPayload(user).setHeader(KafkaHeaders.TOPIC, "user_json").build();

		kafkaJsonTemplate.send(message);

	}

}
