package com.restaurante.restauranteapi.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restaurante.restauranteapi.domain.model.Venda;
import com.restaurante.restauranteapi.domain.repository.VendaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class VendaService {
	
	private VendaRepository vendaRepository;
	
	@Transactional
	public Venda salvar(Venda venda) {
		return vendaRepository.save(venda);
	}
	
	@Transactional
	public void excluir(Long vendaId) {
		vendaRepository.deleteById(vendaId);
	}
}
