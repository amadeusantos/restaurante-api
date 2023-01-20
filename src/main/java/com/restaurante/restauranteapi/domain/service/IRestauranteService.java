package com.restaurante.restauranteapi.domain.service;

import com.restaurante.restauranteapi.domain.model.dto.RestauranteDTO;
import com.restaurante.restauranteapi.domain.exception.NaoEncontradoException;
import com.restaurante.restauranteapi.domain.model.Restaurante;

import java.util.List;

public interface IRestauranteService {

    List<Restaurante> listarRestaurantes();

    Restaurante buscarRestaurante(long id) throws NaoEncontradoException;

    Restaurante incluirRestaurante(RestauranteDTO restauranteDTO) throws NaoEncontradoException;

    Restaurante alterarRestaurante(long id, RestauranteDTO restauranteDTO) throws NaoEncontradoException;

    void excluirRestaurante(long id) throws NaoEncontradoException;
}
