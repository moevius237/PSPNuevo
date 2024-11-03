package UD2.Tarea4.Ej2;

import UD2.Tarea4.Ej2.Tienda;

import java.util.Random;

public class Cajero extends Thread{
    Tienda tienda;
    public Cajero (Tienda tienda){
        this.tienda=tienda;
    }
    @Override
    public void run() {
        Random r = new Random();
        for (int i = 0; i < r.nextInt(3, 6); i++) {
            tienda.agregarVenta(r.nextInt(0, 101));
        }
    }
}
