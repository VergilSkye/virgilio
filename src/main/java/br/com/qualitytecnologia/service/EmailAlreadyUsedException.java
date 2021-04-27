package br.com.qualitytecnologia.service;

import br.com.qualitytecnologia.GeneratedByJHipster;

@GeneratedByJHipster
public class EmailAlreadyUsedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public EmailAlreadyUsedException() {
        super("Email is already in use!");
    }
}
