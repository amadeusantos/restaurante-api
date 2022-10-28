package com.restaurante.restauranteapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurante.restauranteapi.domain.model.Alimento;

@Repository
public interface AlimentoRepository extends JpaRepository<Alimento, String> {

}
