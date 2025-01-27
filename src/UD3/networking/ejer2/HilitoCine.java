package UD3.networking.ejer2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HilitoCine implements Runnable{
    private final Socket socket;

    private final Sala sala;

    public HilitoCine(Socket socket, Sala sala) {
        this.socket = socket;
        this.sala = sala;
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter pw = new PrintWriter(socket.getOutputStream(),true)){
            while (true) {
                String id = br.readLine();
                int respuesta = sala.insertarButaca(id);
                pw.println(respuesta);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
