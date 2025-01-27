package UD3.networking.ejer2;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;

public class CineCliente {
    public static void main(String[] args) {
        final String id = "Pablo";
        try (Socket socket = new Socket("localhost",5000)){
            Random r = new Random();
            try (PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
                 BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))){
                String leido;
                do {
                    pw.println(id);
                    leido = br.readLine();
                    System.out.println(leido);
                }while (!leido.equals("200"));

            }
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
