package com.restaurante.restauranteapi.domain.model.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class ClienteDTO {

    @NotBlank
    private String cpf;

    @NotBlank
    @Size(max = 127)
    private String nome;

    @DateTimeFormat
    private LocalDate nascimento;
}
