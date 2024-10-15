package UD2.Tarea1.Ej2;

public class ThreadEj21 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i < 6; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
