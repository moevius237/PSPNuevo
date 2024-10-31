package UD2.Tarea4.Ej3;


public class MainTienda {
    public static void main(String[] args) {
        Tienda tienda = new Tienda();
        Cajero t1 = new Cajero(tienda);
        Cajero t2 = new Cajero(tienda);
        Cajero t3 = new Cajero(tienda);
        Administrador ad1 = new Administrador(tienda);
        t1.start();
        t2.start();
        t3.start();
        try {
            ad1.join();
            ad1.start();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
