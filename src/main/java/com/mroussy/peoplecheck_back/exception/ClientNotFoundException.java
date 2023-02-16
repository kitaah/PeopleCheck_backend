package com.mroussy.peoplecheck_back.exception;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException(Long id) { super("Le client possédant l'id " + id + " n'a pas été trouvé.");}
}
