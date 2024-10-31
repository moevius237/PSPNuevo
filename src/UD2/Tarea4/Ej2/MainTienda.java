package UD2.Tarea4.Ej2;

import UD2.Tarea4.Ej2.Cajero;
import UD2.Tarea4.Ej2.Tienda;

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
