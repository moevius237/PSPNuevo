package UD1.Tarea1;

import java.io.IOException;

public class Ej6 {
    public static void main(String[] args) {
        String[] comandosCrear = {"mkdir", "FicheroNuevo"};
        String[] comandos = {"mdir", "FicheroNuevo"};
        ProcessBuilder pb = new ProcessBuilder(comandosCrear);
        ProcessBuilder pbE = new ProcessBuilder(comandos);

        try {
            pb.start();
            pbE.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            pb.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
