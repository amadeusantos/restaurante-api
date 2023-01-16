package com.restaurante.restauranteapi.domain.model.dto;

import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class RestauranteDTO {

    @Size(min = 5, max = 255)
    private String endereco;
}
