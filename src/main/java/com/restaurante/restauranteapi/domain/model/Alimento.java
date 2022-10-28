package com.restaurante.restauranteapi.domain.model;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Alimento {
	
	@Id
	@EqualsAndHashCode.Include
	private String lote;
	
	@NotBlank
	private String nome;
	
	private LocalDateTime validade;
	
	@Size(max = 60)
	@Column(name = "origem")
	@NotBlank
	private String localDeOrigem;
	
	@ManyToOne
	private Restaurante restaurante;
	
}
