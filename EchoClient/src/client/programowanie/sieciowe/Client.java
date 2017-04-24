package client.programowanie.sieciowe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            Socket socket = new Socket("localhost", 7);
            BufferedReader keyboard = new BufferedReader(
                    new InputStreamReader(System.in));
            in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());
            System.out.println("Nawiazano polaczenie z: "
                    + socket.getInetAddress());

            String str;
            while (true) {
                System.out.print("> ");
                String text = keyboard.readLine();
                out.println(text);
                out.flush();
                if (text.equals("#"))
                    break;                           
                else{
                    str=in.readLine().replace("@","\n");
                    System.out.println(str);
                }
           }
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
            }
        }
    }
}
