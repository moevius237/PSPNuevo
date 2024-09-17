package UD1.Tarea1;

import java.io.IOException;

public class Ej4 {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("moc ajisfbasuidnchia");
        try {
            pb.start();
        } catch (IOException e) {
            System.out.println("ERROR EJECUTANDO FUNCIONANDO");;
        }
    }
}
