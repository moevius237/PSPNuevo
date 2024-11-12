package UD2.Contenedor;

class Contenedor<String> {
    private String dato;
    public String get() {
        String result = this.dato;
        this.dato = null;
        return result;
    }
    public synchronized void put(String valor) {
        try {
            wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.dato = valor;

    }
    public synchronized boolean isDatoDisponible() {
        notifyAll();
        return (this.dato != null);
    }
}
class HiloProductor implements Runnable {
    private final Contenedor<Integer> contenedor;
    private String nombre;
    public HiloProductor(Contenedor<Integer> contenedor, String nombre) {
        this.nombre = nombre;
        this.contenedor = contenedor;
    }
    @Override
    public void run() {
        for (int i = 1; ; i++) {
            while (this.contenedor.isDatoDisponible()) {
            }
            System.out.printf("Hilo %s produce el valor %d.\n", this.nombre, i);
            this.contenedor.put(i);
        }
    }
}
class HiloConsumidor implements Runnable {
    private Contenedor<Integer> contenedor;
    private final String nombre;
    public HiloConsumidor(Contenedor<Integer> contenedor, String nombre) {
        this.contenedor = contenedor;
        this.nombre = nombre;
    }
    @Override
    public void run() {
        while(true) {
            while (!this.contenedor.isDatoDisponible()) {
            }
            Integer dato = this.contenedor.get();
            System.out.printf("Hilo %s consume el valor %d.\n", nombre, dato);
        }
    }
}
public class ProductorConsumidor {
    public static void main(String[] args) {
        Contenedor<Integer> almacen = new Contenedor<>();
        Thread hprod = new Thread(new HiloProductor(almacen, "P1"));
        Thread hprod2 = new Thread(new HiloProductor(almacen, "P2"));
        Thread hcons = new Thread(new HiloConsumidor(almacen, "C1"));
        Thread hcons2 = new Thread(new HiloConsumidor(almacen, "C2"));
        hprod.start();
        hprod2.start();
        hcons.start();
        hcons2.start();
    }}