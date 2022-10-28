package com.restaurante.restauranteapi.domain.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restaurante.restauranteapi.domain.model.Cliente;
import com.restaurante.restauranteapi.domain.repository.ClienteRepository;
import com.restaurante.restauranteapi.domain.exception.NegocioException;


import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CadastraClienteService {
	
	ClienteRepository clienteRepository;
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
		boolean clienteCadastrado = clienteRepository.findById(cliente.getCpf())
				.stream()
				.anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
		if (clienteCadastrado) {
			throw new NegocioException("Já existe um cliente cadastrado com este CPF.");
		}
		return clienteRepository.save(cliente);
	}
	
	public void excluir(Long cpf) {
		clienteRepository.deleteById(cpf);
	}
}
