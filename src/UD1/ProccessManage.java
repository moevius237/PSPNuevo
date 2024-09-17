package UD1;

import java.io.IOException;

public class ProccessManage {
    public static void main(String[] args) {
        // Runtime y ProccesBuilder
        String [] comandos = {"libreoffice"};
        try {
            Process p = Runtime.getRuntime().exec(comandos);
            ProcessBuilder builder = new ProcessBuilder(comandos);
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
