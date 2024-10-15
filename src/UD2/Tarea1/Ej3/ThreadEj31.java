package UD2.Tarea1.Ej3;

import UD2.Tarea1.Ej2.ThreadEj23;

public class ThreadEj31 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Soy un hilo");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
