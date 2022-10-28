package com.restaurante.restauranteapi.domain.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode.Include;

@Getter
@Setter
@Entity
@EqualsAndHashCode( onlyExplicitlyIncluded = true)
public class Funcionario {
	
	@Id
	@EqualsAndHashCode.Include
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
