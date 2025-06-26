import br.com.henriqueaguiiar.entities.Autor;
import br.com.henriqueaguiiar.entities.Book;
import br.com.henriqueaguiiar.entities.Loan;
import br.com.henriqueaguiiar.utils.ServiceLibrary;


import java.util.ArrayList;
import java.util.List;

public class Library implements ServiceLibrary {
    private List<Book> bookList = new ArrayList<>();
    private List<Autor> autorsList = new ArrayList<>();
    private List<Loan> loanList = new ArrayList<>();


    public List<Book> getBookList(){
        return bookList;
    }

    public List<Autor> getAutorsList(){

        return autorsList;
    }

    public List<Loan> getLoanList(){
        return loanList;
    }

    public void addToList(Book book){
        bookList.add(book);
    }

}
