package br.com.qualitytecnologia.service;

import br.com.qualitytecnologia.GeneratedByJHipster;

@GeneratedByJHipster
public class UsernameAlreadyUsedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UsernameAlreadyUsedException() {
        super("Login name already used!");
    }
}
