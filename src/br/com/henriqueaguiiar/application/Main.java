package br.com.henriqueaguiiar.application;

import br.com.henriqueaguiiar.model.Exceptions.LoanException;
import br.com.henriqueaguiiar.model.entities.Autor;
import br.com.henriqueaguiiar.model.entities.Book;
import br.com.henriqueaguiiar.model.entities.Library;
import br.com.henriqueaguiiar.model.Exceptions.AutorException;
import br.com.henriqueaguiiar.model.Exceptions.BookException;
import br.com.henriqueaguiiar.model.entities.Loan;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Library library = new Library();
        int opcao;

        do{
            System.out.println("\n===== MENU BIBLIOTECA =====");
            System.out.println("1 - Cadastrar autor");
            System.out.println("2 - Cadastrar livro");
            System.out.println("3 - Listar autores");
            System.out.println("4 - Listar livros");
            System.out.println("5 - Realizar empréstimo");
            System.out.println("6 - Editar livro");
            System.out.println("7 - Editar autor");
            System.out.println("8 - Remover livro");
            System.out.println("9 - Remover autor");
            System.out.println("10 - Listar empréstimos");
            System.out.println("11 - Pegar livro por ID");
            System.out.println("12 - Listar livros disponíveis");
            System.out.println("13 - Realizar devolução");
            System.out.println("0 - Sair");
            System.out.print("\nEscolha uma opção: ");
            opcao = input.nextInt();
            input.nextLine();

            switch (opcao){
                case 1:
                    try{
                        System.out.print("\nEnter the author's name: ");
                        String name = input.nextLine();
                        System.out.print("Enter the author's date of birth (dd/MM/yyyy): ");
                        String bornDateSDF = input.nextLine();
                        Date bornDate = sdf.parse(bornDateSDF);
                        Autor autor = new Autor(name, bornDate);
                        library.addAutorToLIst(autor);
                    }catch(ParseException erro){
                        System.out.println("Invalid date format. Use dd/MM/yyyy.");
                    }
                    break;
                case 2:
                    System.out.print("Enter the title of the book: ");
                    String nameTitle = input.nextLine();
                    System.out.print("Enter the name of the author for this book: ");
                    String authorName = input.nextLine();
                    Autor authorFound = null;
                    for(Autor autor: library.getAutorsList()){
                        if(autor.getName().equalsIgnoreCase(authorName)){
                            authorFound = autor;
                            break;
                        }
                    }
                    if(authorFound != null){
                        Book book = new Book(nameTitle, authorFound);
                        library.addBookToList(book);
                    }
                    else{
                        System.out.println("Author not found. Please register the author first (Option 1).");
                    }
                    break;
                case 3:
                    try{
                        if(library.getAutorsList().isEmpty()){
                            throw new AutorException("The autor list is empty. Please register the author first (Option 1)");
                        }
                        for(Autor autor : library.getAutorsList()){
                            System.out.println(autor);
                        }
                    }catch(AutorException erro){
                        System.out.println(erro.getMessage());
                    }
                    break;
                case 4:
                    try{
                        if(library.getBookList().isEmpty()){
                            throw new BookException("The book list is empty. Please register the book first (Option 2)");
                        }
                        for(Book book : library.getBookList()){
                            System.out.println(book);
                        }
                    }catch(BookException erro){
                        System.out.println(erro.getMessage());
                    }
                    break;
                case 5:
                    try{
                        if(library.getBookList().isEmpty()){
                            throw new BookException("The book list is empty. Please register the book first (Option 2)");
                        }
                        System.out.print("Enter the name book: ");
                        String nameBOok = input.nextLine();
                        System.out.print("Enter the username: ");
                        String username = input.nextLine();
                        boolean flagValidate = false;
                        for(Book book : library.getBookList()){
                            if(book.getTitleName().equalsIgnoreCase(nameBOok)){
                                library.loanValidate(book, username);
                                System.out.println("Loan completed successfully!");
                                flagValidate = true;
                                break;
                            }
                        }
                        if(!flagValidate){
                                System.out.println("Book not found, check if the book is registered in option 4.");
                        }
                    }catch (BookException | LoanException erro){
                        System.out.println(erro.getMessage());
                    }
                    break;
                case 6:
                    try{
                        System.out.print("Enter the book name: ");
                        String bookName = input.nextLine().trim().toLowerCase();
                        boolean found = false;
                        for(Book book : library.getBookList()){
                            if(book.getTitleName().equalsIgnoreCase(bookName)){
                                String idBook = book.getId().trim().toLowerCase();
                                System.out.print("Enter the new title Name: ");
                                String titleName = input.nextLine();
                                library.updateBook(idBook, titleName);
                                found = true;
                                break;
                            }
                        }
                        if(!found){
                            throw  new BookException("Book with the given ID does not exist.");
                        }
                    }catch (BookException erro){
                        System.out.println(erro.getMessage());
                    }
                    break;
                case 7:
                    try{
                        System.out.print("Enter the autor name: ");
                        String autorName = input.nextLine().trim().toLowerCase();
                        boolean found = false;
                        for(Autor autor : library.getAutorsList()){
                            if(autor.getName().equalsIgnoreCase(autorName)){
                                String idAutor = autor.getId().trim().toLowerCase();
                                System.out.print("Enter the new autor name: ");
                                String newAutorName = input.nextLine();
                                String newBornDateSDF = null;
                                    System.out.print("Enter the new author's date of birth (dd/MM/yyyy): ");
                                    newBornDateSDF = input.nextLine();
                                    Date newBornDate = sdf.parse(newBornDateSDF);

                                library.updateAutor(idAutor, newAutorName,newBornDate);
                                found = true;
                                break;
                            }
                        }
                        if(!found){
                            throw  new AutorException("Autor with the given ID does not exist.");
                        }
                    }catch (AutorException  erro){
                        System.out.println(erro.getMessage());
                    }catch (ParseException erro){
                        System.out.println("Invalid date format. Use dd/MM/yyyy.");
                    }
                    break;
                case 8:
                    try{
                        System.out.print("Enter the book name: ");
                        String bookName = input.nextLine().trim().toLowerCase();
                        boolean found = false;
                        String idBook = null;
                        for(Book book : library.getBookList()){
                            if(book.getTitleName().equalsIgnoreCase(bookName)) {
                                idBook = book.getId().trim().toLowerCase();
                                found = true;
                                break;
                            }
                        }
                        library.removeBookList(idBook);
                        if(!found) {
                            throw new BookException("Book with the given ID does not exist.");
                        }
                    }catch (BookException erro){
                        System.out.println(erro.getMessage());
                    }
                    break;
                case 9:
                    try{
                        System.out.print("Enter the Autor name: ");
                        String autorName = input.nextLine().trim().toLowerCase();
                        boolean found = false;
                        String idAutor = null;
                        for(Autor autor : library.getAutorsList()){
                            if(autor.getName().equalsIgnoreCase(autorName)){
                                idAutor = autor.getId().trim().toLowerCase();
                                found = true;
                                break;
                            }
                        }
                        library.removeAutorList(idAutor);
                        if(!found){
                            throw  new AutorException("Autor with the given ID does not exist.");
                        }
                    }catch (AutorException erro){
                        System.out.println(erro.getMessage());
                    }
                    break;
                case 10:
                    try{
                        if(library.getLoanList().isEmpty()){
                            throw new LoanException("The loan list is empty.");
                        }
                        for(Loan loan : library.getLoanList()){
                            System.out.println(loan);
                        }
                    }catch (LoanException erro){
                        System.out.println(erro.getMessage());
                    }
                    break;
            }
        }while(opcao != 0);
        System.out.println("Logging out Thank you until next time!");

    input.close();
    }
}
