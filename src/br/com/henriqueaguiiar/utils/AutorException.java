package br.com.henriqueaguiiar.utils;

public class AutorException extends RuntimeException{
    private static final Long serialVersionUID = 1L;

    public AutorException(String message) {
        super(message);
    }
}
