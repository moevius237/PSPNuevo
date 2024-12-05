package UD2.executorTask1.Task1;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * utilizar newFixed.. para ejecutar varias tareas que retornan un valor
 * Recoger esos valores
 *Tareas a ejecutar
 * 1. sumar de un array de enteros y devuelve la suma
 * 2. calculo del factoriol de 10
 * 3 Encontrar el minimo del array de enteros
 * 4 Transformar un texto String en mayusculas
 *
 *Quiero ejecutar las 4 tareas de forma asincrona y concurrente y
 * recoger el valor y mostrarlo
 *
 *
 */
public class Taks1 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);
        String loco = "estoy loco";
        int array1 [] = {1,2,3,4,5,6};
        Future<Integer> suma = service.submit(() -> Taks1.sumasArray(array1));
        Future<Integer> fact= service.submit(() -> Taks1.factorial10());
        Future<Integer> min = service.submit(() -> Taks1.minimoEnArray(array1));
        Future<String> mayus= service.submit(() -> Taks1.mayusTexto(loco));
        try {
            System.out.println(suma.get());
            System.out.println(min.get());
            System.out.println(mayus.get());
            System.out.println(fact.get());
            service.shutdown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }


    }

    public static int sumasArray(int array[]){
        return Arrays.stream(array).sum();
    }

    public static int factorial10(){
        int a = 1;
        for (int i = 1; i < 10; i++) {
            a = i*a;
        }
        return a;
    }
    public static int minimoEnArray(int[] array){
        return Arrays.stream(array).min().getAsInt();
    }

    public static String mayusTexto(String texto) {
        return texto.toUpperCase();
    }

}
