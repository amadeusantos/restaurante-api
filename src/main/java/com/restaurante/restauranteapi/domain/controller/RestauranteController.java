package com.restaurante.restauranteapi.domain.controller;

import java.util.List;

import javax.validation.Valid;

import com.restaurante.restauranteapi.domain.model.dto.RestauranteDTO;
import com.restaurante.restauranteapi.domain.exception.NaoEncontradoException;
import com.restaurante.restauranteapi.domain.service.IRestauranteService;
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

import com.restaurante.restauranteapi.domain.model.Restaurante;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

	@Autowired
	private IRestauranteService restauranteService;

	@GetMapping
	public List<Restaurante> listarRestaurantes() {
		return restauranteService.listarRestaurantes();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarRestaurante(@PathVariable long id) {
		try {
			return ResponseEntity.ok(restauranteService.buscarRestaurante(id));
		} catch (NaoEncontradoException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	
	
	@PostMapping
	public ResponseEntity<?> adicionarRestaurante(@Valid @RequestBody RestauranteDTO restauranteDTO) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(restauranteService.incluirRestaurante(restauranteDTO));
		} catch (NaoEncontradoException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizarRestaurante(@PathVariable long id, @Valid @RequestBody RestauranteDTO restauranteDTO) {
		try {
			return ResponseEntity.ok(restauranteService.alterarRestaurante(id, restauranteDTO));
		} catch (NaoEncontradoException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluirRestaurante(@PathVariable long id) {
		try {
			restauranteService.excluirRestaurante(id);
		} catch (NaoEncontradoException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

		return ResponseEntity.noContent().build();
	}
	
}
