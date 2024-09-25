package UD1.Tarea2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ej2 {
    public static void main(String[] args) {
        String [] co = {"ls","coabnsb"};
        ProcessBuilder pb = new ProcessBuilder(co);
        try {
            Process p = pb.start();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(p.getErrorStream()))){
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
