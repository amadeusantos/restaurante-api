package com.restaurante.restauranteapi.domain.controller;

import java.util.List;

import javax.validation.Valid;

import com.restaurante.restauranteapi.domain.exception.NaoEncontradoException;
import com.restaurante.restauranteapi.domain.model.dto.ClienteDTO;
import com.restaurante.restauranteapi.domain.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.restauranteapi.domain.model.Cliente;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private IClienteService clienteService;

	@GetMapping
	public List<Cliente> listarClientes() {
		return clienteService.listarClientes();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarCliente(@PathVariable long id) {
		try {
			return ResponseEntity.ok(clienteService.buscarCliente(id));
		} catch (NaoEncontradoException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PostMapping
	public ResponseEntity<?> incluirCliente(@Valid @RequestBody ClienteDTO clienteDTO) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(clienteService.incluirCliente(clienteDTO));
		} catch (NaoEncontradoException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> alterarCliente(@PathVariable long id, @Valid @RequestBody ClienteDTO clienteDTO) {
		try {
			return ResponseEntity.ok(clienteService.alterarCliente(id, clienteDTO));
		} catch (NaoEncontradoException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable long id) {
		try {
			clienteService.excluirCliente(id);
		} catch (NaoEncontradoException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.noContent().build();
	}
	
	
}
