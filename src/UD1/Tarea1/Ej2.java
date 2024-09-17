package UD1.Tarea1;

import java.io.IOException;

public class Ej2 {
    public static void main(String[] args) {
        ProcessBuilder builder = new ProcessBuilder("ls");
        try {
            Process process = builder.start();
            int code = process.waitFor();
            System.out.println(code);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
