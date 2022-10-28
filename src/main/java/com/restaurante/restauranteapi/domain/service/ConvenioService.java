package com.restaurante.restauranteapi.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restaurante.restauranteapi.domain.model.Convenio;
import com.restaurante.restauranteapi.domain.repository.ConvenioRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ConvenioService {

	private ConvenioRepository convenioRepository;
	
	@Transactional
	public Convenio salvar(Convenio convenio) {
		return convenioRepository.save(convenio);
	}
	
	@Transactional
	public void excluir(Long convenioId) {
		convenioRepository.deleteById(convenioId);
	}
}
