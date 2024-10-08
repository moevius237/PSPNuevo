package UD2.Tarea;

public class Ej2F2 implements Runnable {
    @Override
    public void run() {
        Thread qe = new Ej2F1();
        try {
            qe.join();
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(1111);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
