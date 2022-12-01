package com.example.kafkaTutorial.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafkaTutorial.kafka.KafkaProducer;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {
	
	private KafkaProducer kafkaProducer ;
	
	public MessageController(KafkaProducer kafkaProducer) {
		this.kafkaProducer = kafkaProducer ;
	}
	
	//http:localhost:8080/api/v1/kafka/publish?message=The future
	@GetMapping("/publish")
	public ResponseEntity<String>  publish(@RequestParam("message") String message){
     kafkaProducer.sendMessage(message);
     return ResponseEntity.ok("Meesage sent to tht topic");
	}

}

