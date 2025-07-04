package br.com.henriqueaguiiar.model.Exceptions;

public class BookException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public BookException(String message) {
        super(message);
    }
}
