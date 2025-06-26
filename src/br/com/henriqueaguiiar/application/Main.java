package br.com.henriqueaguiiar.application;

import br.com.henriqueaguiiar.entities.Autor;
import br.com.henriqueaguiiar.entities.Book;

import java.util.Date;

public class Main {
    public static void main(String[] args) {


        Autor autor = new Autor("Tolkie", new Date());
        Book book = new Book("Lord of the Rings",autor);

        System.out.println(book);


    }
}
