package server.programowanie.sieciowe;

import java.util.ArrayList;
import java.util.Scanner;
/** 
 * Klasa abstrakcyjna Book. Implementuje interfejs Comparable<Book>
 * Klasa posiada pola wspólne dla wszystkich książek.
 * Znajdują tu się też 2 finalne metody, compareTo i equals.
 * @author Bartek
 */
public abstract class Book implements Comparable<Book> {

    private Scanner read;
    private ArrayList books;

    private double value;
    private int ISBNnumber;
    private String title, author, publisher;

    public Book() {
        this(0000);
    }

    public Book(int ISBNnumber) {
        this(ISBNnumber, "TITLE");
    }

    public Book(int ISBNnumber, String title) {
        this(ISBNnumber, title, "AUTHOR");
    }

    public Book(int ISBNnumber, String title, String author) {
        this(ISBNnumber, title, author, "PUBLISHER");
    }

    public Book(int ISBNnumber, String title, String author,
            String publisher) {
        this(ISBNnumber, title, author, publisher, 9.99);
    }
    
    public Book(int ISBNnumber, String title, String author,
            String publisher, double value) {
        this.ISBNnumber = ISBNnumber;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.value = value;
    }
    public String toString() {
        return "ISBN:" + ISBNnumber + " Tytuł:" + title + " Autor:" + author + " Wydawca:" + publisher + " Cena:" + value + "zł ";
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getISBNnumber() {
        return ISBNnumber;
    }

    public void setISBNnumber(int ISBNnumber) {
        this.ISBNnumber = ISBNnumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    /** Metoda finalna, 
     * implementowana z interfejsu Comparable.
     * @param b przyjmuje obiekt typu Book
     * @return 
     */
    @Override
    public final int compareTo(Book b) {
        if(this.getISBNnumber()>b.getISBNnumber())
            return 1;
        else if(this.getISBNnumber()<b.getISBNnumber())
            return -1;
        else
            return 0;
    }
    /** Metoda finalna porównywania
     * Pozwala porównać Książki które rozszeżają klasę Book
     * @param b przyjmuje obiekt typu Book
     * @return 
     */
    public final boolean equals(Book b){
        if(this.getISBNnumber()>b.getISBNnumber() || this.getISBNnumber()<b.getISBNnumber())
            return false;
        return true;
    }
}
