package com.restaurante.restauranteapi.domain.service;

import com.restaurante.restauranteapi.domain.exception.NaoEncontradoException;
import com.restaurante.restauranteapi.domain.model.Cliente;
import com.restaurante.restauranteapi.domain.model.dto.ClienteDTO;

import java.util.List;

public interface IClienteService {

    List<Cliente> listarClientes();

    Cliente buscarCliente(long id) throws NaoEncontradoException;

    Cliente incluirCliente(ClienteDTO clienteDTO) throws NaoEncontradoException;

    Cliente alterarCliente(long id, ClienteDTO clienteDTO) throws NaoEncontradoException;

    void excluirCliente(long id) throws NaoEncontradoException;

}
