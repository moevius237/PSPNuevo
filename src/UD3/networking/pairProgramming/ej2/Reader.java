package UD3.networking.pairProgramming.ej2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Reader implements Runnable{
    private Socket socket;

    public Reader(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))){
            System.out.println("Funciona");
            while (true){
                String line = br.readLine();
                System.out.println(line);
                if (line!=null) {
                    System.out.println(line);
                }else{
                    if (line.equals("exit")){
                        break;
                    }
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
