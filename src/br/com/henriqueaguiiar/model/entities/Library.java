package br.com.henriqueaguiiar.model.entities;
import br.com.henriqueaguiiar.model.Exceptions.AutorException;
import br.com.henriqueaguiiar.model.Exceptions.BookException;
import br.com.henriqueaguiiar.model.Exceptions.LoanException;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Library {
    private List<Book> bookList;
    private List<Autor> autorsList;
    private List<Loan> loanList;

    public Library() {
        this.bookList = new ArrayList<>();
        this.autorsList = new ArrayList<>();
        this.loanList = new ArrayList<>();
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public List<Autor> getAutorsList() {
        return autorsList;
    }

    public List<Loan> getLoanList() {
        return loanList;
    }

    public void addAutorToLIst(Autor autor) {
        autorsList.add(autor);
    }

    public void addBookToList(Book book) {
        bookList.add(book);
    }

    public List<Book> listBookAvailable() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getAvailable() == true) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }


    public Book getBookById(String id) {
        for (Book book : bookList) {
            if (book.getId().equalsIgnoreCase(id)) {
                return book;
            }
        }
        throw new BookException("The requested book does not exist or the id is invalid");
    }

    public void removeAutorList(String id) {
        for(int i = 0; i < autorsList.size(); i++){
            if(autorsList.get(i).getId().equalsIgnoreCase(id)){
                autorsList.remove(i);
                return;
            }
        }
        throw new AutorException("The requested author does not exist or the id is invalid");
    }

    public void removeBookList(String id) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getId().equalsIgnoreCase(id)) {
                bookList.remove(i); //
                return;
            }
        }
        throw new BookException("The requested book does not exist or the id is invalid");
    }

    public void updateAutor(String id, String newNameAutor, Date newBornDate) {
        for(Autor autor : autorsList){
            if(autor.getId().equalsIgnoreCase(id)){
                autor.setName(newNameAutor);
                autor.setBornDate(newBornDate);
                return;
            }
        }
        throw new BookException("The requested autor does not exist or the id is invalid");
    }

    public void updateBook(String id, String newTitle) {
        for(Book book : bookList){
            if(book.getId().equalsIgnoreCase(id)){
                book.setTitleName(newTitle);
                book.setUpdatedDate(LocalDate.now());
                return;
            }
        }
        throw new BookException("The requested book does not exist or the id is invalid");
    }

    public void loanValidate(Book book, String userName) {
            if(book.getAvailable() == true){
                Loan loan = new Loan(book, userName);
                loanList.add(loan);
                book.setAvailable(false);
                loan.setLoanStatus(true);
                return;
            }
            throw new LoanException("The book is not available for loan");
        }
    public void loanReturn(String id){
        for(Loan loan: loanList){
            if(loan.getId() == id && loan.getLoanStatus() == true){
                loan.loanReturn();
                break;
            }
        }
    }

}
