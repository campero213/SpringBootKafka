package com.kafka.provider.entity;

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
	private static final long serialVersionUID = 9050474035599794317L;
	@JsonProperty("id")
	private int id;
	@JsonProperty("nombre")
	private String nombre;
	@JsonProperty("email")
	private String email;
}
