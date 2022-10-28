package com.restaurante.restauranteapi.domain.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.restauranteapi.domain.model.Convenio;
import com.restaurante.restauranteapi.domain.repository.ClienteRepository;
import com.restaurante.restauranteapi.domain.repository.ConvenioRepository;
import com.restaurante.restauranteapi.domain.repository.RestauranteRepository;
import com.restaurante.restauranteapi.domain.service.ConvenioService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/convenios")
public class ConvenioController {

	private ConvenioService convenioService;
	private ConvenioRepository convenioRepository;
	private RestauranteRepository restauranteRepository;
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public List<Convenio> listar() {
		return convenioRepository.findAll();
	}
	
	@GetMapping("/{convenioId}")
	public ResponseEntity<Convenio> buscar(@PathVariable Long convenioId) {
		return convenioRepository.findById(convenioId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/{restId}/{clienteId}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Convenio> adicionar(@PathVariable Long restId, @PathVariable Long clienteId, @RequestBody Convenio convenio) {
		if (!(restauranteRepository.existsById(restId) || clienteRepository.existsById(clienteId))) {
			return ResponseEntity.notFound().build();
		}
		convenio.setCliente(clienteRepository.findById(clienteId).orElse(null));
		convenio.setRestaurante(restauranteRepository.findById(restId).orElse(null));
		return ResponseEntity.ok(convenioService.salvar(convenio));
	}
	
	@DeleteMapping("/{convenioId}")
	public ResponseEntity<Convenio> remover(@PathVariable Long convenioId) {
		if (!convenioRepository.existsById(convenioId)) {
			return ResponseEntity.notFound().build();
		}
		convenioService.excluir(convenioId);
		return ResponseEntity.noContent().build();
	}
}
