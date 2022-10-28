package com.restaurante.restauranteapi.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restaurante.restauranteapi.domain.model.Funcionario;
import com.restaurante.restauranteapi.domain.repository.FuncionarioRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class FuncionarioService {
	
	private FuncionarioRepository funcionarioRepository;
	
	@Transactional
	public Funcionario salvar(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}

	@Transactional
	public void excluir(Long funcId) {
		funcionarioRepository.deleteById(funcId);;
	}
}
