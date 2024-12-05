package UD2.ejExcutioner.ej2;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Dinero {
    private int valor = 0;
    public Dinero(int valorInicial) {
        this.valor = valorInicial;
    }
    public synchronized int getValor() {
        return valor;
    }
    public synchronized void recolectar(int cantidad) {
        this.valor+= cantidad;
    }
    public synchronized void retirar(int cantidad) {
        this.valor-= cantidad;
    }
}
class HiloConsumidor implements Runnable {
    private final String id;
    private final Dinero dinero;
    private static final int minDin = 10;
    private static final int maxDin = 40;
    private static final int tMin = 20;
    private static final int tMax = 300;
    public HiloConsumidor(String id, Dinero dinero) {
        this.id = id;
        this.dinero = dinero;
    }
    @Override
    public void run() {
        while(true) {
            Random random = new Random();
            try {
                Thread.sleep(random.nextInt(tMin, tMax+1));
            } catch (InterruptedException e) {
            }
            int dineroRecibido = random.nextInt(minDin,maxDin + 1);
            synchronized (this.dinero) {
                int retirarDinero = this.dinero.getValor() - dineroRecibido;
                while (retirarDinero < 0) {
                    System.out.println("Hilo " + id + " no puede retirar " +
                            dineroRecibido + " euros porque no hay tanto dinero en la colecta " +
                            this.dinero.getValor());
                    try {
                        this.dinero.wait();
                    } catch (InterruptedException e) {
                    }
                }
                this.dinero.retirar(dineroRecibido);
                this.dinero.notifyAll();
                System.out.println("Hilo " + id + " retira "+ dineroRecibido + " de  la colecta. Total: " + this.dinero.getValor());
            }
        }
    }
}
class HiloRecolector implements Runnable {
    private final String id;
    private final Dinero dinero;
    private static final int MAX_COLECTA = 200;
    private static final int minDinColecta = 10;
    private static final int maxDinColecta = 50;
    public HiloRecolector(String id, Dinero dinero) {
        this.id = id;
        this.dinero = dinero;
    }
    @Override
    public void run() {
        Random random = new Random();
        while(true) {
            synchronized (this.dinero) {
                int dinColectado = random.nextInt(minDinColecta,maxDinColecta+1);
                System.out.println("Hilo " + id + " recolecta " + dinColectado);
                while ((this.dinero.getValor() + dinColectado) >= MAX_COLECTA) {
                    System.out.println("Hilo " + id + " recolector, ya no puede recoger más dinero.");
                    try {
                        this.dinero.wait();
                    } catch (InterruptedException e) {
                    }
                }
                this.dinero.recolectar(dinColectado);
                this.dinero.notifyAll();
                System.out.println("Hilo " + id + " recolecta " + dinColectado + " euros más. Total: " + this.dinero.getValor());
            }
        }
    }
}
class MainColecta {
    private static final int NUM_HILOS_REC = 3;
    private static final int NUM_HILOS_CON = 1;
    public static void main(String[] args) {
        Dinero dinero = new Dinero(0);
        Thread[] hilos = new Thread[NUM_HILOS_REC];
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_HILOS_CON);
        for (int i = 0; i < hilos.length; i++) {
            executorService.submit(new HiloRecolector("Recolectando "+i, dinero));
        }
            ExecutorService executorService1 = Executors.newFixedThreadPool(NUM_HILOS_REC);
            executorService1.submit(new HiloConsumidor("Consumidor " + 1, dinero));


    }

}