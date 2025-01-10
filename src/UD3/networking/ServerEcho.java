package UD3.networking;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerEcho {
    public static void main(String[] args) {
      // Puertos ocupados  0-65535
        try (ServerSocket serverSocket = new ServerSocket(5000);){
           Socket socket = serverSocket.accept();
            System.out.println("CLiente conectado");
            new Thread(new Hilito(socket)).start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
