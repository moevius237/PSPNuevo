package UD2.Tarea4.EJ1;

public class MainTienda {
    public static void main(String[] args) {
        Tienda tienda = new Tienda();
        Cajero t1 = new Cajero(tienda);
        Cajero t2 = new Cajero(tienda);
        Cajero t3 = new Cajero(tienda);
        t1.start();
        t2.start();
        t3.start();
    }

}
