package br.com.henriqueaguiiar.model.entities;

import java.time.LocalDate;
import java.util.UUID;

public class Loan {
    private String id;
    private Book book;
    private LocalDate loanDate;
    private LocalDate returnDate;
    private boolean loanStatus;
    private String userName;


    public Loan(Book book, String userName) {
        this.id = UUID.randomUUID().toString();
        this.book = book;
        this.loanDate = LocalDate.now();
        this.userName = userName;
        this.loanStatus = true;
    }

    public String getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public boolean getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(boolean loanStatus) {
        this.loanStatus = loanStatus;
    }

    public void loanReturn(){
        this.returnDate = LocalDate.now();
        this.loanStatus = false;
        this.book.setAvailable(true);
    }

    private String availableConvert(boolean loanStatus){
        String newStatus;
        if(loanStatus == true){
            newStatus = "borrowed";
        }
        else{
            newStatus = "Not borrowed";
        }
        return newStatus;
    }


    @Override
    public String toString(){
        return "Id: " + this.id
                +"Book: " + this.book
                +"Loan Date: " + this.loanDate
                +"Loan Status: "+ availableConvert(this.loanStatus)
                +"Loan Return: "+ this.returnDate
                +"User: " + userName;
    }
}
