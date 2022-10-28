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

import com.restaurante.restauranteapi.domain.model.Venda;
import com.restaurante.restauranteapi.domain.repository.ClienteRepository;
import com.restaurante.restauranteapi.domain.repository.FuncionarioRepository;
import com.restaurante.restauranteapi.domain.repository.VendaRepository;
import com.restaurante.restauranteapi.domain.service.VendaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/vendas")
public class VendaController {
	
	private VendaRepository vendaRepository;
	private VendaService vendaService;
	private FuncionarioRepository funcionarioRepository;
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public List<Venda> listar() {
		return vendaRepository.findAll();
	}
	
	@GetMapping("/{vendaId}")
	public ResponseEntity<Venda> buscar(@PathVariable Long vendaId) {
		return vendaRepository.findById(vendaId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/{funcId}/{clienteId}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Venda> adicionar(@PathVariable Long funcId, @PathVariable Long clienteId, @RequestBody Venda venda) {
		if (!(funcionarioRepository.existsById(funcId) || clienteRepository.existsById(clienteId))) {
			return ResponseEntity.notFound().build();
		}
		venda.setFuncionario(funcionarioRepository.findById(funcId).orElse(null));
		venda.setCliente(clienteRepository.findById(clienteId).orElse(null));
		return ResponseEntity.ok(vendaService.salvar(venda));
	}
	
	@PutMapping("/{vendaId}")
	public ResponseEntity<Venda> adicionar(@PathVariable Long vendaId, @RequestBody Venda venda) {
		if(!vendaRepository.existsById(vendaId)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(vendaService.salvar(venda));
	}
	
	@DeleteMapping("/{vendaId}")
	public ResponseEntity<Void> remover(@PathVariable Long vendaId) {
		if (!vendaRepository.existsById(vendaId)) {
			return ResponseEntity.notFound().build();
		}
		vendaService.excluir(vendaId);
		return ResponseEntity.noContent().build();
	}
}
