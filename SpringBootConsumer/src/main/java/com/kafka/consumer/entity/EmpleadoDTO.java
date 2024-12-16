package com.kafka.consumer.entity;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonProperty;

import lombok.Data;

@Data
@JsonAutoDetect
public class EmpleadoDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2010941266871788601L;
	@JsonProperty("id")
	private int id;
	@JsonProperty("nombre")
	private String nombre;
	@JsonProperty("email")
	private String email;
}
