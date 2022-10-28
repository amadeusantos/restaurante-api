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

import com.restaurante.restauranteapi.domain.model.Cargo;
import com.restaurante.restauranteapi.domain.repository.CargoRepository;
import com.restaurante.restauranteapi.domain.service.CadastraCargoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/cargos")
public class CargoController {

	private CadastraCargoService cadastraCargoService;
	private CargoRepository cargoRepository;
	
	@GetMapping
	public List<Cargo> listar() {
		return cargoRepository.findAll();
	}
	
	@GetMapping("/{cargoId}")
	public ResponseEntity<Cargo> buscar(@PathVariable String cargoId) {
		return cargoRepository.findById(cargoId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Cargo> adicionar(@Valid @RequestBody Cargo cargo) {
		if (cargoRepository.existsById(cargo.getId())) {
			return ResponseEntity.notFound().build();
		}
		cadastraCargoService.salvar(cargo);
		return ResponseEntity.ok(cargo);
	}
	
	@PutMapping("/{cargoId}")
	public ResponseEntity<Cargo> atualizar(@PathVariable String cargoId,@Valid @RequestBody Cargo cargo) {
		if (!cargoRepository.existsById(cargoId)) {
			return ResponseEntity.notFound().build();
		}
		cargo.setId(cargoId);
		cadastraCargoService.salvar(cargo);
		return ResponseEntity.ok(cargo);
	}
	
	@DeleteMapping("/{cargoId}")
	public ResponseEntity<Void> remover(@PathVariable String cargoId){
		if (!cargoRepository.existsById(cargoId)) {
			return ResponseEntity.notFound().build();
		}
		cadastraCargoService.excluir(cargoId);
		return ResponseEntity.noContent().build();
	}
	
	
}
