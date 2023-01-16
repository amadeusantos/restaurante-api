package com.restaurante.restauranteapi.domain.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario {
	
	@Id
	private Long cpf;
	
	@NotBlank
	private String nome;
	
	private LocalDateTime admissao;
	
	private boolean ativo;
	
	@ManyToOne
	private Cargo cargo;
	
	@ManyToOne
	private Restaurante restaurante;
	
}
