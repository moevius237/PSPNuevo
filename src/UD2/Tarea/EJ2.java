package UD2.Tarea;

public class EJ2 {
    //Creamos tres hilos de diferentes formas , luego unimos dos hilos al otro que queda muestra la ejecucion del programa
    public static void main(String[] args) {
        Thread e = new Ej2F1();
        Runnable r1 = new Ej2F2();
        Thread eq = new Thread(r1);
        Runnable r = () -> {
            try {
                e.join();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            for (int i = 0; i < 5; i++) {
                System.out.println("Macaco");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        };
        Thread thread = new Thread(r);
        e.start();
        thread.start();
        eq.start();
    }
}
