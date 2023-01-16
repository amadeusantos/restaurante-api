package com.restaurante.restauranteapi.domain.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CargoDTO {

    @NotBlank
    private String nome;

    @NotNull
    private float salario;

    @NotNull
    private int cargaHoraria;

}
