package UD2.Tarea4.Ej3;


import java.util.Random;

public class Administrador extends Thread{
    Tienda tienda;
    public Administrador(Tienda tienda){
        this.tienda=tienda;
    }
    @Override
    public void run() {
        Random r = new Random();
        int decuento = r.nextInt(1,100);
        tienda.aplicarDEscuento(decuento);
    }
}
