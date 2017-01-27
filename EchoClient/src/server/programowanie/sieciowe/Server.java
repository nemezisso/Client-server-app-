package server.programowanie.sieciowe;

import java.io.*;
import java.net.*;

public class Server {

    public static final int PORT = 7;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Uruchomiono serwer: "
                + serverSocket);
        try {
            System.out.println("Oczekiwanie na polaczenie...");
            Socket socket = serverSocket.accept();
            BufferedReader in = null;
            PrintWriter out = null;
            try {
                in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(new BufferedWriter(
                        new OutputStreamWriter(
                                socket.getOutputStream())), true);
                System.out.println("Otwarto polaczenie: " + socket);
                
                while (true) {
                    String text = in.readLine();
                    ServerHandler rh=new ServerHandler(socket,text,out);
                    if (text.equals("#"))
                        break;
                    else
                        rh.start();
                }
            } finally {
                System.out.println("Zamykanie ...");
                try {
                    if (in != null) {
                        in.close();
                    }
                    if (out != null) {
                        out.close();
                    }
                } catch (Exception e) {
                }
                socket.close();
            }
        } finally {
            serverSocket.close();
        }
    }
}