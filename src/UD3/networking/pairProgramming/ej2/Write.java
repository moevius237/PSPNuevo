package UD3.networking.pairProgramming.ej2;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Write implements Runnable{
    private Socket socket;
    private String message;

    public Write(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        String mes="";
        try (PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true)){
            do{
                Scanner sc = new Scanner(System.in);
                mes = sc.next();
                pw.write(socket.getLocalAddress()+": "+mes);
            }while (!mes.equals("exit"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
