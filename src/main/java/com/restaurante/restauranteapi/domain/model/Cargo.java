package com.restaurante.restauranteapi.domain.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
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
public class Cargo {
	
	@Id
	@EqualsAndHashCode.Include
	private String id;
	
	private float salario;
	
	@Column(name = "carga_horaria")
	private int carga;
	

}
