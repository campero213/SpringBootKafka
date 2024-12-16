package com.kafka.consumer.listeners;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

import com.kafka.consumer.entity.EmpleadoDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class KafkaConsumerListener {
	
	@KafkaListener(topics = {"unProgramadorName-Topic"}, groupId = "my-group-id")
	public void listener(String mensaje) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			log.info("Mensaje Recibido, el mensaje es: " + mensaje);
			EmpleadoDTO empleadoDTO = objectMapper.readValue(mensaje, EmpleadoDTO.class);
			log.info("Objeto: " + empleadoDTO.toString());
		}catch (Exception e) {
			log.error("Se genero un error: " + e);
		}
	}
}
