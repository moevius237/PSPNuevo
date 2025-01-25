package UD3.networking.ejer1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class HilitoEjer implements Runnable {
    private final Socket socket;
    private final AlmacenTP almacenTP;
    public HilitoEjer(Socket socket, AlmacenTP almacenTP) {
        this.socket = socket;
        this.almacenTP = almacenTP;
    }

    @Override
    public void run() {
        try (socket;
             BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String compra;
            while ((compra = br.readLine())!= null) {
                String[] inserto = compra.split("#");
                almacenTP.insertarProducto(inserto[0], Integer.valueOf(inserto[1]));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}