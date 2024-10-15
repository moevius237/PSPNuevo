package UD2.Tarea1.Ej1;

public class HiloEj1 extends Thread {
        @Override
        public void run() {
            try {
                System.out.println("Dormir hilo 2");
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("Me interrumpieron");
            }
        }
    }
