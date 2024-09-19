package UD1.Tarea1;

import java.io.IOException;
import java.time.LocalDateTime;

public class EJ7 {
    public static void main(String[] args) {
        String [] comandos = {"ping","192.168.0.0"};
        ProcessBuilder pb = new ProcessBuilder(comandos);
        try {
            while (true){
                if (pb.start().isAlive()){
                    Thread.sleep(3000);
                    System.out.println("Estoy vivo");
                }else {
                    break;
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
