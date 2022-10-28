package com.restaurante.restauranteapi.domain.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.restaurante.restauranteapi.domain.model.Restaurante;
import com.restaurante.restauranteapi.domain.repository.RestauranteRepository;
import com.restaurante.restauranteapi.domain.service.CadastraRestauranteService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {
	
	private RestauranteRepository restauranteRepository;
	private CadastraRestauranteService cadastraRestauranteService;
	
	@GetMapping
	public List<Restaurante> listar() {
		return restauranteRepository.findAll();
	}
	
	@GetMapping("/{restId}")
	public ResponseEntity<Restaurante> buscar(@PathVariable Long restId) {
		return restauranteRepository.findById(restId).map(ResponseEntity :: ok).orElse(ResponseEntity.notFound().build());
	}
	
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Restaurante adicionar(@Valid @RequestBody Restaurante restaurante) {
		return cadastraRestauranteService.salvar(restaurante);
		
	}
	
	
	@PutMapping("/{restId}")
	public ResponseEntity<Restaurante> atualizar(@PathVariable Long restId, @Valid @RequestBody Restaurante restaurante) {
		if (!restauranteRepository.existsById(restId)) {
			return ResponseEntity.notFound().build();
		}
		restaurante.setId(restId);
		cadastraRestauranteService.salvar(restaurante);
		return ResponseEntity.ok(restaurante);
	}
	
	@DeleteMapping("/{restId}")
	public ResponseEntity<Void> excluir(@PathVariable Long restId) {
		if (!restauranteRepository.existsById(restId)) {
			return ResponseEntity.notFound().build();
		}
		cadastraRestauranteService.excluir(restId);
		return ResponseEntity.noContent().build();
	}
	
}
