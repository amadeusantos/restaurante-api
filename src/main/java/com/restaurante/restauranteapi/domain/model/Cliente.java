package com.restaurante.restauranteapi.domain.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String cpf;
	
	@NotBlank
	private String nome;

	private LocalDate nascimento;
	
}
