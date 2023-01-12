package com.restaurante.restauranteapi.domain.exception;

public class NaoEncontradoException extends Exception {

    private static final long serialVersionUID = 1L;

    public NaoEncontradoException(String message) {
        super(message);
    }

}
