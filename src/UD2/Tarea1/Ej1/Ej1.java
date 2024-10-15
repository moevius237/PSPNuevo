package UD2.Tarea1.Ej1;

public class Ej1 {


    public static void main(String[] args) {
        HiloEj1 hiloEj1 = new HiloEj1();
        HiloEj12 hiloEj12 = new HiloEj12(hiloEj1);
        hiloEj12.start();
        hiloEj1.start();

    }
}
