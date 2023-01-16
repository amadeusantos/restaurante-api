package com.restaurante.restauranteapi.domain.controller;

import java.util.List;

import javax.validation.Valid;

import com.restaurante.restauranteapi.domain.exception.NaoEncontradoException;
import com.restaurante.restauranteapi.domain.model.dto.CargoDTO;
import com.restaurante.restauranteapi.domain.service.ICargoService;
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

import com.restaurante.restauranteapi.domain.model.Cargo;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/cargos")
public class CargoController {

	@Autowired
	private ICargoService cargoService;
	
	@GetMapping
	public List<Cargo> listarCargos() {
		return cargoService.listarCargos();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarCargo(@PathVariable long id) {
		try {
			return ResponseEntity.ok(cargoService.buscarCargo(id));
		} catch (NaoEncontradoException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PostMapping
	public ResponseEntity<?> incluirCargo(@Valid @RequestBody CargoDTO cargoDTO) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(cargoService.incluirCargo(cargoDTO));
		} catch (NaoEncontradoException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> alterarCargo(@PathVariable long id, @Valid @RequestBody CargoDTO cargoDTO) {
		try {
			return ResponseEntity.ok(cargoService.alterarCargo(id, cargoDTO));
		} catch (NaoEncontradoException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluirCargo(@PathVariable long id){
		try {
			cargoService.excluirCargo(id);
		} catch (NaoEncontradoException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

		return ResponseEntity.noContent().build();
	}

}
