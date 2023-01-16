package com.restaurante.restauranteapi.domain.service;

import com.restaurante.restauranteapi.domain.exception.NaoEncontradoException;
import com.restaurante.restauranteapi.domain.model.Cargo;
import com.restaurante.restauranteapi.domain.model.dto.CargoDTO;
import com.restaurante.restauranteapi.domain.repository.CargoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CargoService implements ICargoService {

    @Autowired
    private CargoRepository cargoRepository;

    @Override
    public List<Cargo> listarCargos() {
        return cargoRepository.findAll();
    }

    @Override
    public Cargo buscarCargo(Long id) throws NaoEncontradoException {
        Optional<Cargo> cargo = cargoRepository.findById(id);

        if (cargo.isEmpty()) {
            throw new NaoEncontradoException("Cargo não encontrado.");
        }

        return cargo.get();
    }

    @Override
    public Cargo incluirCargo(CargoDTO cargoDTO) throws NaoEncontradoException {
        return cargoRepository.save(converterDTO(cargoDTO));
    }

    @Override
    public Cargo alterarCargo(Long id, CargoDTO cargoDTO) throws NaoEncontradoException {

        if (!cargoRepository.existsById(id)) {
            throw new NaoEncontradoException("Cargo não encontrado.");
        }

        Cargo cargo = converterDTO(cargoDTO);
        cargo.setId(id);

        return cargoRepository.save(cargo);
    }

    @Override
    public void excluirCargo(Long id) throws NaoEncontradoException {

        if (!cargoRepository.existsById(id)) {
            throw new NaoEncontradoException("Cargo não encontrado.");
        }

        cargoRepository.deleteById(id);
    }

    private Cargo converterDTO(CargoDTO cargoDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(cargoDTO, Cargo.class);
    }

}
