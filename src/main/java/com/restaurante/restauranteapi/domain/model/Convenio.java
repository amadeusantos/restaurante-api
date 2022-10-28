package com.restaurante.restauranteapi.domain.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Convenio {

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDateTime renovacao;
	
	@ManyToOne
	private Restaurante restaurante;
	
	@ManyToOne
	private Cliente cliente;
	

	private double valor;
}
