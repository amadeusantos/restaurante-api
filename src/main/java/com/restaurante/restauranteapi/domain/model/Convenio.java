package com.restaurante.restauranteapi.domain.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Convenio {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDateTime renovacao;
	
	@ManyToOne
	private Restaurante restaurante;
	
	@ManyToOne
	private Cliente cliente;
	

	private double valor;
}
