package com.kafka.provider.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
	
	@Bean
	public NewTopic generateTopic() {
		Map<String, String> configuraciones = new HashMap<>();	
		configuraciones.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE);	//Tratameinto de borrado de msj, delete (borra el msj), compact (mantiene el mas actual)
		configuraciones.put(TopicConfig.RETENTION_MS_CONFIG, "86400000");	//Tiempo de retención de mensajes (default -1: no se borran)
		configuraciones.put(TopicConfig.SEGMENT_BYTES_CONFIG, "1073741824");	//Tamaño maximo por el sehmento (por default 1 GB)
		configuraciones.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "125000");	//Tamaño maximo de los msj (por defecto 1MB)
		
		NewTopic newTopic = TopicBuilder.name("unProgramadorName-Topic")
				.partitions(1)
				.replicas(1)
				.configs(configuraciones)
				.build();
		
		return newTopic;
	}
	
}
