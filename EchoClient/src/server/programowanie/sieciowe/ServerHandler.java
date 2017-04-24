package server.programowanie.sieciowe;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerHandler extends Thread{
    Socket socket;
    String text;
    PrintWriter out;
    ArrayList<Book> bookshop;
    OptionsBookstore options;

    public ServerHandler(Socket socket,PrintWriter out){
        this.socket=socket;
        this.out=out;
        options=new OptionsBookstore();
        bookshop=options.load();
    }

    public void setText(String text){
        this.text=text;
    }

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
