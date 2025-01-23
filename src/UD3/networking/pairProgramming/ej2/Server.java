package UD3.networking.pairProgramming.ej2;

import UD3.networking.tcp.Hilito;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        // Puertos ocupados  0-65535
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            Socket socket = serverSocket.accept();
            System.out.println("CLiente conectado");

                new Thread(new Reader(socket)).start();
                new Thread(new Write(socket)).start();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
