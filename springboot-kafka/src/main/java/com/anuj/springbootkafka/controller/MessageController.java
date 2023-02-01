package com.anuj.springbootkafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anuj.springbootkafka.kafka.KafkaProducer;
import com.anuj.springbootkafka.payload.User;

@RestController
public class MessageController {
	
	@Autowired
	private KafkaProducer kafkaProducer;
	
	//publish simple message
	@GetMapping("/publish")
	public ResponseEntity<String> publish(@RequestParam String message){
		kafkaProducer.sendMessage(message);
		return ResponseEntity.ok("message sent to the producer");
		
	}
	
	//publish user object
	@PostMapping("/publishUser")
	public ResponseEntity<String> publish(@RequestBody User user){
		System.out.println("user Recieved: " + user.toString());
		kafkaProducer.sendMessage_Json(user);
		return ResponseEntity.ok("message sent to the producer");
		
	}


}
