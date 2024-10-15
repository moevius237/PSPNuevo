package UD2.Tarea1.ej6;

public class ThreadEj61 extends Thread{
    @Override
    public void run() {
        try {
        while (true){

                Thread.sleep(1000);
                System.out.println("No morire");
        }
        } catch (InterruptedException e) {
            System.out.println("Murio");
        }
    }
}
