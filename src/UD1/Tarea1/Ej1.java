package UD1.Tarea1;

import java.io.IOException;

public class Ej1 {
    public static void main(String[] args) {
        try {
            Runtime.getRuntime().exec("kcalc");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
