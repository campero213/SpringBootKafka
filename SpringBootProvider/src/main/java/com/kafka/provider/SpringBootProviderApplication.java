package com.kafka.provider;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

import com.kafka.provider.entity.EmpleadoDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class SpringBootProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProviderApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(KafkaTemplate<String, String> kafkaTemplate){
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			EmpleadoDTO empleadoDTO = new EmpleadoDTO();
			empleadoDTO.setId(1);
			empleadoDTO.setNombre("Juanito");
			empleadoDTO.setEmail("juanito@mail.com");
			String requestJSON = objectMapper.writeValueAsString(empleadoDTO);
			log.info(requestJSON);
			return args -> {
				//kafkaTemplate.send("unProgramadorName-Topic", "Hola mundo kafka desde springboot 04");
				kafkaTemplate.send("unProgramadorName-Topic", requestJSON);
			};
		}catch (Exception e) {
			log.error("Ocurrio un error: " + e);
		}
		return null;
	}

}
