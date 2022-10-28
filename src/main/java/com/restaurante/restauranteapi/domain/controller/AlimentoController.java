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

import com.restaurante.restauranteapi.domain.model.Alimento;
import com.restaurante.restauranteapi.domain.repository.AlimentoRepository;
import com.restaurante.restauranteapi.domain.repository.RestauranteRepository;
import com.restaurante.restauranteapi.domain.service.CadastraAlimentoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/alimentos")
public class AlimentoController {

	private AlimentoRepository alimentoRepository;
	private CadastraAlimentoService cadastraAlimentoService;
	private RestauranteRepository restauranteRepository;
	
	@GetMapping
	public List<Alimento> listar() {
		return alimentoRepository.findAll();
	}
	
	@GetMapping("/{alimentoId}")
	public ResponseEntity<Alimento> buscar(@PathVariable String alimentoId) {
		return alimentoRepository.findById(alimentoId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/restaurante/{restId}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Alimento> adicionar(@PathVariable Long restId, @RequestBody Alimento alimento) {
		if (alimentoRepository.existsById(alimento.getLote())) {
			return ResponseEntity.notFound().build();
		}
		alimento.setRestaurante(restauranteRepository.findById(restId).orElse(null));
		cadastraAlimentoService.salvar(alimento);
		return ResponseEntity.ok(alimento);
	}
	
	@DeleteMapping("/{alimentoId}")
	public ResponseEntity<Void> remover(@PathVariable String alimentoId) {
		if (!alimentoRepository.existsById(alimentoId)) {
			return ResponseEntity.notFound().build();
		}
		cadastraAlimentoService.excluir(alimentoId);
		return ResponseEntity.noContent().build();
	}
	
}
