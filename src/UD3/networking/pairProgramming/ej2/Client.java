package UD3.networking.pairProgramming.ej2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Scanner sc = new Scanner(System.in);
        try {

            Socket socket = new Socket("localhost", 5000);
            new Thread(new Write(socket)).start();
            new Thread(new Reader(socket)).start();


        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
