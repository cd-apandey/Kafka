package com.example.kafkaTutorial.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafkaTutorial.kafka.JsonKafkaProducer;
import com.example.kafkaTutorialpayload.Student;

@RestController
@RequestMapping("/api/v1/kafka/sjson")
public class JsonMessageController {

	 private JsonKafkaProducer kafkaProducer ;

	 public JsonMessageController(JsonKafkaProducer kafkaProducer) {
		this.kafkaProducer = kafkaProducer;
	 }
	 
	 @PostMapping("/")
	 public ResponseEntity<String> publsh(@RequestBody Student student){
		  
		 kafkaProducer.sendMessage(student);
		 return ResponseEntity.ok("Student data received");
	 }
	
	
}
