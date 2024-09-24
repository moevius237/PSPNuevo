package UD1.Tarea2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ej1 {
    public static void main(String[] args) {
        String cos[] = {"echo", "Hello World"};

        ProcessBuilder pb = new ProcessBuilder(cos);
        try {
            Process p = pb.start();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()))){
                String linea;
                while ((linea = br.readLine())!= null){
                    System.out.println(linea);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
