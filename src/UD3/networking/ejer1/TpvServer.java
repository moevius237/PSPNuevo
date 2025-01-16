package UD3.networking.ejer1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TpvServer {
    public static void main(String[] args) {
        AlmacenTP almacenTP = new AlmacenTP();
        try (ServerSocket serverSocket = new ServerSocket(5000)){
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(new HilitoEjer(socket, almacenTP)).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
