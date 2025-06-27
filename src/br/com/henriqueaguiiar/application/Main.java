package br.com.henriqueaguiiar.application;

import br.com.henriqueaguiiar.entities.Autor;
import br.com.henriqueaguiiar.entities.Book;
import br.com.henriqueaguiiar.entities.Library;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
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
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    try{
                        System.out.print("\nEnter the author's name: ");
                        String name = input.nextLine();
                        System.out.print("Enter the author's date of birth (dd/MM/yyyy): ");
                        String bornDateSDF = input.nextLine();
                        Date bornDate = sdf.parse(bornDateSDF);
                        Autor autor = new Autor(name, bornDate);
                        library.addAutorToLIst(autor);
                    }catch(ParseException erro){
                        System.out.println("Formato de data inválido. Use dd/MM/yyyy.");
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
                    if(authorFound != null){
                        Book book = new Book(nameTitle, authorFound);
                        library.addBookToList(book);
                    }
                    else{
                        System.out.println("Author not found. Please register the author first (Option 1).");
                    }
                    break;
                    }
            }

        }while(opcao != 0);

















    input.close();
    }
}
