package library.io;

import library.model.Book;
import library.model.LibraryUser;
import library.model.Magazine;

import java.util.Scanner;

public class DataReader {
    private Scanner sc = new Scanner(System.in);
    private ConsolePrinter printer;

    // konstruktor, który obiekterm typu
    // ConsolePrinter będze wyświetlał komunikaty w konsoli
    public DataReader(ConsolePrinter printer){
        this.printer = printer;
    }

    //metoda do wczytywana formatu danych w postaci stringa
    public String getString(){
        return sc.nextLine();
    }

    // metoda zamykająca strumień
    public void close() {
        sc.close();
    }

    // odczytywanie pojedyńczej liczby typu int
    public int getInt(){
        try{
            return sc.nextInt();
        } finally {
            sc.nextLine();
        }
    }

    public LibraryUser createLibraryUser(){
        printer.printLine("Imię");
        String firstName = sc.nextLine();
        printer.printLine("Nazwisko");
        String lastName = sc.nextLine();
        printer.printLine("Pesel");
        String pesel = sc.nextLine();
        return new LibraryUser(firstName, lastName, pesel);
    }

    // metoda tworząca książkę, zwracająca nowy obiekt
    public Book readAndCreateBook() {
        System.out.println("Tytuł: ");
        String title = sc.nextLine();
        System.out.println("Autor: ");
        String author = sc.nextLine();
        System.out.println("Wydawnictwo: ");
        String publisher = sc.nextLine();
        System.out.println("ISBN: ");
        String isbn = sc.nextLine();
        System.out.println("Rok wydania: ");
        int releaseDate = getInt();
        System.out.println("Ilość stron: ");
        int pages = getInt();

        return new Book(title, author, releaseDate, pages, publisher, isbn);
    }

    public Magazine readAndCreateMagazine() {
        System.out.println("Tytuł: ");
        String title = sc.nextLine();
        System.out.println("Wydawnictwo: ");
        String publisher = sc.nextLine();
        System.out.println("Język: ");
        String language = sc.nextLine();
        System.out.println("Rok wydania: ");
        int year = getInt();
        System.out.println("Miesiąc: ");
        int month = getInt();
        System.out.println("Dzień: ");
        int day = getInt();

        return new Magazine(title, publisher, language, year, month, day);
    }
}