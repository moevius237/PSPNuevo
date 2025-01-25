package UD3.networking.tcp;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class EchoTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try (Socket socket = new Socket("localhost", 5000)) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter bw = new PrintWriter(socket.getOutputStream(),true)) {
                String textoServidor = "";
                do {
                    textoServidor = sc.next();
                    bw.println(textoServidor);
                    System.out.println(br.readLine());
                }while (!textoServidor.equals("exit"));
                System.out.println(br.readLine());
            }
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}