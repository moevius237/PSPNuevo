package UD3.networking.tcp;

import java.io.*;
import java.net.Socket;

public class Hilito implements Runnable {
    private Socket socket;

    public Hilito(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
            while (true) {
                String text = br.readLine();
                if (text.equals("exit")) {
                    break;
                }
                System.out.println(text);
                bw.write(text);
                bw.newLine();
                bw.flush();

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}