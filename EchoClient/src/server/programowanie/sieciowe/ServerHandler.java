package server.programowanie.sieciowe;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Klasa ServerHandler
 * Jest to klasa rozszerzająca klasę Thread
 * Dzięki niej może zostać utworzony wątek w klasie Server
 * @author Bartek
 */
public class ServerHandler extends Thread{
    Socket socket;
    String text;
    PrintWriter out;
    ArrayList<Book> bookshop;
    OptionsBookstore options;
    /**
     * Konstruktor klasy ServerHandler
     * Ustawia on pola:
     * @param socket 
     * @param text tekst od klienta
     * @param out
     * Tworzy on także obiekt klasy OptionsBookstore
     * Ładuje do ArrayList listę obiektów(książek) za pomocą obiektu options i metody load
     */
    public ServerHandler(Socket socket,String text,PrintWriter out){
        this.socket=socket;
        this.text=text;
        this.out=out;
        options=new OptionsBookstore();
        bookshop=options.load();
    }
    /**
     * Przeciążona metoda run z klasy Thread
     * Tutaj tworzy się wątek i wykonuje sekwencja wysyłania informacji do klienta
     */
    public void run(){
        if(text.startsWith("show:"))
            options.showReply(out, text, bookshop);
        else if(text.startsWith("search ISBN:"))
            OptionsBookstore.searchBooksByISBN(text, bookshop, out);
        else if(text.equals("sort"))
            OptionsBookstore.sortByISBN(bookshop, out);
        else
            out.println("ERROR!");
    }
}