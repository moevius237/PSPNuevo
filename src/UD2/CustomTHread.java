package UD2;

import java.sql.Time;

public class CustomTHread {
    /*
    Proceso crea uno o mas hilos como minimo siempre crea un hilo el cual es el principal cual es el main Thread
    Todos los hilos comparten el mismo espacio de memoria en el proceso
     */
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        thread.setPriority(Thread.MAX_PRIORITY);
      //  printThreadState(thread);
        ThreadHija hija = new ThreadHija();
        hija.start();
        for (int i = 0; i < 3; i++) {
            System.out.println(1);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.getStackTrace();
            }
        }
        Runnable r = () ->{
            for (int i = 0; i < 5; i++) {
                System.out.println(2);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }

    /**
     * Prioridad de 1 a 10
     * 10 es el que mas prioridad tiene 1 es el que menos
     */
    public static void printThreadState(Thread thread){
        System.out.println(thread.threadId() + thread.getName() + thread.getPriority() + thread.isAlive());
    }
}
