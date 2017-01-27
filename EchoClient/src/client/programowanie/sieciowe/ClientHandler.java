package client.programowanie.sieciowe;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientHandler extends Thread{
    Socket socket;
    BufferedReader in;
    
    public ClientHandler(Socket socket,BufferedReader in){
        this.socket=socket;
        this.in=in;
    }
   
    public void run(){
        String serverText;
       
            while(true){  
                try {
                    serverText=in.readLine();
                    if(serverText.equals("#"))
                        Thread.interrupted();
                    else
                        System.out.println("++Pobrano:"+serverText);
                        
                } catch (IOException ex) {
                    Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
                    break;
                }
            }
   }
}