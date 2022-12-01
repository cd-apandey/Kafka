package com.example.kafkaTutorial.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.example.kafkaTutorialpayload.Student;

@Service
public class JsonKafkaProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);
    
	
	private KafkaTemplate<String,Student> kafkaTemplate ;
	
	
	public JsonKafkaProducer(KafkaTemplate<String, Student> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}


	public void sendMessage(Student student) {
		
		LOGGER.info(String.format("Message sent -> %s", student.toString()));
		
		
		Message<Student> message = MessageBuilder.withPayload(student).setHeader(KafkaHeaders.TOPIC,"jsonStudent").build();
	    kafkaTemplate.send(message);
	}
}
