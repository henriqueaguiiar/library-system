package br.com.henriqueaguiiar.model.Exceptions;

public class LoanException extends RuntimeException{
    private static final long serialVersionUID = 1L;


    public LoanException(String message) {
        super(message);
    }
}
