package br.com.henriqueaguiiar.model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Autor {
    private String id;
    private String name;
    private Date bornDate;


    public Autor(String name, Date bornDate) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.bornDate = bornDate;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dateFormatted = sdf.format(this.bornDate); // <-- CORRETO
        return "\nId: " + this.id
                + "\nAutor Name: " + this.name
                + "\nBorn Date: " + dateFormatted;
    }
}