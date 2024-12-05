package UD2.executorTask1.Task2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**Vamos a hacer un sistema de cancenlacion de tareas
 * Vamos a ejecutar una tarea larga: bucle de contar hasta 10 y entre contar 2s
 * Crear un mecanismo para cancelar esta tarea antes de que finalize
 */
public class Task2 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future <?> future = service.submit(() -> Task2.devolver());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (!future.isCancelled()){
            future.cancel(true);
        }
        System.out.println("a dormir");
        service.shutdown();

    }
    public static void devolver(){
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
