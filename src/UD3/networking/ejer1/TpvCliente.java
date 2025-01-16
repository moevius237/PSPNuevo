package UD3.networking.ejer1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;

public class TpvCliente {
    public static void main(String[] args) {
        final String [] productos = {"leche" , "arroz" , "aceite", "tomates", "turron", "jamon" , "mermelada", "mantequilla" , "kebabs"};
        try (Socket socket = new Socket("localhost",5000)){
            Random r = new Random();
            try (PrintWriter pw = new PrintWriter(socket.getOutputStream(),true)){
                for (int i = 0; i < 100; i++) {
                    System.out.println("askjda");
                    String envio = productos[r.nextInt(0,9)] + "#" + r.nextInt(1,11);
                    pw.println(envio);
                    Thread.sleep(r.nextInt(1000,5000));

                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
