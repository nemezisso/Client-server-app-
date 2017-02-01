package server.programowanie.sieciowe;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        else if(text.startsWith("add classic: ")){
           try {
                        options.addClassicBook(text.substring(13));
           } catch (IOException ex) {
             Logger.getLogger(ServerHandler.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
        else if(text.startsWith("add ebook: ")){
                   try {
                        options.addEbook(text.substring(11));
                   } catch (IOException ex) {
                    Logger.getLogger(ServerHandler.class.getName()).log(Level.SEVERE, null, ex);
                   }
        }
        else if(text.startsWith("add audio: ")){
                   try {
                        options.addAudioBook(text.substring(11));
                   } catch (IOException ex) {
                    Logger.getLogger(ServerHandler.class.getName()).log(Level.SEVERE, null, ex);
                   }
        }
        else
           out.println("ERROR!");
    }
}