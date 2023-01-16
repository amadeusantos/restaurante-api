package com.restaurante.restauranteapi.domain.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Alimento {
	
	@Id
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
