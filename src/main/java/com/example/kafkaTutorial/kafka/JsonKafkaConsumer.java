package com.example.kafkaTutorial.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.kafkaTutorialpayload.Student;

@Service	
public class JsonKafkaConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);
	
	
	@KafkaListener(topics="jsonStudent",groupId = "test")
	public void consume(Student student) {
		LOGGER.info(String.format("Json Message Recived", student.toString()));
		
	}
}
