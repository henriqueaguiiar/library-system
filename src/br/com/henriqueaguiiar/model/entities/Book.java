package br.com.henriqueaguiiar.model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Book {
    private String id;
    private String titleName;
    private Autor autor;
    private boolean available;
    private LocalDate  registerDate;
    private LocalDate updatedDate;

    public Book(String titleName, Autor autor) {
        this.id = UUID.randomUUID().toString();
        this.titleName = titleName;
        this.autor = autor;
        this.available = true;
        this.registerDate = LocalDate.now();
        this.updatedDate = LocalDate.now();
    }

    public String getId() {
        return id;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public boolean getAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }

    public LocalDate getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDate updatedDate) {
        this.updatedDate = updatedDate;
    }

    private String availableConvert(boolean available){
        String newAvailable;
        if(available == true){
             newAvailable = "Available";
        }
        else{
            newAvailable = "Not available";
        }
        return newAvailable;
    }

    @Override
    public String toString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "--- BOOK DESCRIPTION---\n"+
                "-----------------------\n"+
                "ID: "+ this.id
                +"\nBook Title: " + this.titleName
                +"\nBook Autor: "+ this.autor.getName()
                +"\nRegistre Date: "+ this.registerDate.format(formatter)
                +"\nAvailable: " + availableConvert(this.available);
    }

}
