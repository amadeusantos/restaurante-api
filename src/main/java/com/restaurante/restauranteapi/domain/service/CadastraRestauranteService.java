package com.restaurante.restauranteapi.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restaurante.restauranteapi.domain.exception.NegocioException;
import com.restaurante.restauranteapi.domain.model.Restaurante;
import com.restaurante.restauranteapi.domain.repository.RestauranteRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CadastraRestauranteService {

	private RestauranteRepository restauranteRepository;
	
	@Transactional
	public Restaurante salvar(Restaurante restaurante) {
		return restauranteRepository.save(restaurante);
	}
	
	@Transactional
	public void excluir(Long restId) {
		restauranteRepository.deleteById(restId);
	}
	
}
