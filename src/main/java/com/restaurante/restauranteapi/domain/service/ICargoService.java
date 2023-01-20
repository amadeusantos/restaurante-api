package com.restaurante.restauranteapi.domain.service;

import com.restaurante.restauranteapi.domain.exception.NaoEncontradoException;
import com.restaurante.restauranteapi.domain.model.Cargo;
import com.restaurante.restauranteapi.domain.model.dto.CargoDTO;

import java.util.List;

public interface ICargoService {

    List<Cargo> listarCargos();

    Cargo buscarCargo(long id) throws NaoEncontradoException;

    Cargo incluirCargo(CargoDTO cargoDTO) throws NaoEncontradoException;

    Cargo alterarCargo(long id, CargoDTO cargoDTO) throws NaoEncontradoException;

    void excluirCargo(long id) throws NaoEncontradoException;

}
