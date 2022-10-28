package com.restaurante.restauranteapi.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restaurante.restauranteapi.domain.model.Alimento;
import com.restaurante.restauranteapi.domain.repository.AlimentoRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CadastraAlimentoService {
	
	AlimentoRepository alimentoRepository;
	
	@Transactional
	public Alimento salvar(Alimento alimento) {
		return alimentoRepository.save(alimento);
	}
	
	@Transactional
	public void excluir(String alimentoId) {
		alimentoRepository.deleteById(alimentoId);
	}
}
