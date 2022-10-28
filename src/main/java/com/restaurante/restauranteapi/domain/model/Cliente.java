package com.restaurante.restauranteapi.domain.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
public class Cliente {
	
	
	@Id
	@EqualsAndHashCode.Include
	private Long cpf;
	
	@NotBlank
	@Size(max = 60)
	private String nome;
	
	
	
	private LocalDateTime nascimento;
	
}
