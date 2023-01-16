package com.restaurante.restauranteapi.domain.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
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
	private Long cpf;
	
	@NotBlank
	@Size(max = 60)
	private String nome;
	
	
	
	private LocalDateTime nascimento;
	
}
