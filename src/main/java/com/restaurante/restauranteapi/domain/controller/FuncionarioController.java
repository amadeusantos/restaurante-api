package com.restaurante.restauranteapi.domain.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.restauranteapi.domain.model.Funcionario;
import com.restaurante.restauranteapi.domain.repository.CargoRepository;
import com.restaurante.restauranteapi.domain.repository.FuncionarioRepository;
import com.restaurante.restauranteapi.domain.repository.RestauranteRepository;
import com.restaurante.restauranteapi.domain.service.FuncionarioService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	private FuncionarioRepository funcionarioRepository;
	private FuncionarioService funcionarioService;
	
	private RestauranteRepository restauranteRepository;
	private CargoRepository cargoRepository;
	
	@GetMapping
	public List<Funcionario> listar() {
		return funcionarioRepository.findAll();
	}
	
	@GetMapping("/{funcId}")
	public ResponseEntity<Funcionario> buscar(@PathVariable Long funcId) {
		return funcionarioRepository.findById(funcId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("restaurante/{restId}/{cargoId}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Funcionario> adicionar(@PathVariable Long restId, @PathVariable String cargoId, @RequestBody Funcionario funcionario) {
		if (funcionarioRepository.existsById(funcionario.getCpf())) {
			return ResponseEntity.notFound().build();
		}
		funcionario.setRestaurante(restauranteRepository.findById(restId).orElse(null));
//		funcionario.setCargo(cargoRepository.findById(cargoId).orElse(null));
		funcionarioService.salvar(funcionario);
		return ResponseEntity.ok(funcionario);
	}
	
	@PutMapping("/{funcId}")
	public ResponseEntity<Funcionario> atualizar(@PathVariable Long funcId, @RequestBody Funcionario funcionario) {
		if (!funcionarioRepository.existsById(funcId)) {
			return ResponseEntity.notFound().build();
		}
		funcionario.setCpf(funcId);
		funcionarioService.salvar(funcionario);
		return ResponseEntity.ok(funcionario);
	}
	
	@DeleteMapping("/{funcId}")
	public ResponseEntity<Void> remover(@PathVariable Long funcId) {
		if (!funcionarioRepository.existsById(funcId)) {
			return ResponseEntity.notFound().build();
		}
		funcionarioService.excluir(funcId);
		return ResponseEntity.noContent().build();
	}
}
