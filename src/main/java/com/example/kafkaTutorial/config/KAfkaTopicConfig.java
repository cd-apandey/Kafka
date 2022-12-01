package com.example.kafkaTutorial.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KAfkaTopicConfig {
	
	
	@Bean
	public NewTopic topics() {
         return TopicBuilder.name("test").build() ;	
	}

}
