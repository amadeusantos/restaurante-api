package com.restaurante.restauranteapi.domain.service;

import com.restaurante.restauranteapi.domain.model.dto.RestauranteDTO;
import com.restaurante.restauranteapi.domain.exception.NaoEncontradoException;
import com.restaurante.restauranteapi.domain.model.Restaurante;
import com.restaurante.restauranteapi.domain.repository.RestauranteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestauranteService implements IRestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Override
    public List<Restaurante> listarRestaurantes() {
        return restauranteRepository.findAll();
    }

    @Override
    public Restaurante buscarRestaurante(long id) throws NaoEncontradoException {
        Optional<Restaurante> restauranteOptional = restauranteRepository.findById(id);

        if (restauranteOptional.isEmpty()) {
            throw new NaoEncontradoException("Restaurante não encontrado.");
        }

        return restauranteOptional.get();
    }

    @Override
    public Restaurante incluirRestaurante(RestauranteDTO restauranteDTO) throws NaoEncontradoException {
        return restauranteRepository.save(converterDTO(restauranteDTO));
    }

    @Override
    public Restaurante alterarRestaurante(long id, RestauranteDTO restauranteDTO) throws NaoEncontradoException {

        if (!restauranteRepository.existsById(id)) {
            throw new NaoEncontradoException("Restaurante não encontrado.");
        }

        Restaurante restaurante = converterDTO(restauranteDTO);
        restaurante.setId(id);

        return restauranteRepository.save(restaurante);
    }

    @Override
    public void excluirRestaurante(long id) throws NaoEncontradoException {

        if (!restauranteRepository.existsById(id)) {
            throw new NaoEncontradoException("Restaurante não encontrado.");
        }

        restauranteRepository.deleteById(id);
    }

    private Restaurante converterDTO(RestauranteDTO restauranteDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(restauranteDTO, Restaurante.class);
    }
}
