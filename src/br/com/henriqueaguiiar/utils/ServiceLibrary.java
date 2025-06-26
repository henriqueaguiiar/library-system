package br.com.henriqueaguiiar.utils;


import br.com.henriqueaguiiar.entities.Autor;
import br.com.henriqueaguiiar.entities.Book;
import br.com.henriqueaguiiar.entities.Loan;

import java.util.List;

public interface ServiceLibrary {
    void addToList(Book book);

    List<Book> getBookList();

    List<Autor> getAutorsList();

    List<Loan> getLoanList();
}