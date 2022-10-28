package com.restaurante.restauranteapi.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restaurante.restauranteapi.domain.model.Cargo;
import com.restaurante.restauranteapi.domain.repository.CargoRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CadastraCargoService {
	
	private CargoRepository cargoRepository;
	
	@Transactional
	public Cargo salvar(Cargo cargo) {
		return cargoRepository.save(cargo);
	}
	
	@Transactional
	public void excluir(String cargoId) {
		cargoRepository.deleteById(cargoId);
	}
}
