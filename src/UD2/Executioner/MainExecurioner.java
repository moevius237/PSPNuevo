package UD2.Executioner;

import UD2.ThreadColor;

import java.util.concurrent.*;

public class MainExecurioner {
    public static int cuentaAtras() {
        int i;
        for (i = 0; i < 10; i++) {
            System.out.println(ThreadColor.ANSI_BLUE +Thread.currentThread().getName() + i);
        }
        return i;
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        try {
            Future<?> resultado = executor.submit(() -> MainExecurioner.cuentaAtras());
            System.out.println(resultado.get());

        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            executor.shutdown();
        }
        System.out.println("EL ACABADO");
    }
}
