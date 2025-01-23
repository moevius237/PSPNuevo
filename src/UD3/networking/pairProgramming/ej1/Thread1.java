package UD3.networking.pairProgramming.ej1;

import java.io.*;
import java.net.DatagramPacket;
import java.nio.file.Path;
import java.time.LocalDateTime;

public class Thread1 implements Runnable {
    private DatagramPacket message;

    public Thread1(DatagramPacket message) {
        this.message = message;
    }

    private final String path = "file/pair.txt";
    @Override
    public void run() {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
        while (message != null){
            synchronized (message) {
                bw.write(new String(message.getData(), 0, message.getLength()) + " " + LocalDateTime.now());
                bw.newLine();
                bw.flush();
            }
        }
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    }
}
