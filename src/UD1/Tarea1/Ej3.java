package UD1.Tarea1;

import java.io.IOException;

public class Ej3 {
    public static void main(String[] args) {
        String [] comandos = {"ps" , "-li"};
        ProcessBuilder builder = new ProcessBuilder(comandos);
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
