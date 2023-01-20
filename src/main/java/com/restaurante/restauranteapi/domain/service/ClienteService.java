package com.restaurante.restauranteapi.domain.service;

import com.restaurante.restauranteapi.domain.exception.NaoEncontradoException;
import com.restaurante.restauranteapi.domain.model.Cliente;
import com.restaurante.restauranteapi.domain.model.dto.ClienteDTO;
import com.restaurante.restauranteapi.domain.repository.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    @Override
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarCliente(long id) throws NaoEncontradoException {

        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isEmpty()) {
            throw new NaoEncontradoException("Cliente não encontrado.");
        }

        return cliente.get();
    }

    @Override
    public Cliente incluirCliente(ClienteDTO clienteDTO) throws NaoEncontradoException {
        return clienteRepository.save(converterDTO(clienteDTO));
    }

    @Override
    public Cliente alterarCliente(long id, ClienteDTO clienteDTO) throws NaoEncontradoException {

        if (!clienteRepository.existsById(id)) {
            throw new NaoEncontradoException("Cliente não encontrado.");
        }

        Cliente cliente = converterDTO(clienteDTO);
        cliente.setId(id);
        return clienteRepository.save(cliente);
    }

    @Override
    public void excluirCliente(long id) throws NaoEncontradoException {

        if (!clienteRepository.existsById(id)) {
            throw new NaoEncontradoException("Cliente não encontrado.");
        }

        clienteRepository.deleteById(id);

    }

    private Cliente converterDTO(ClienteDTO clienteDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(clienteDTO, Cliente.class);
    }
}
