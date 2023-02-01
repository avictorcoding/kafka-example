package com.anuj.springbootkafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
	
	@Bean
	 NewTopic employeeStatusTopic() {
		return TopicBuilder.name("employeeStatus")
				.build();
		
	}
	
	@Bean
	 NewTopic employeeStatusTopic_Json() {
		return TopicBuilder.name("user_json")
				.build();
		
	}

}
