package UD2.mesas;

import java.util.Random;

public class Escritor extends Thread{
    private MesasRepositorio mesasRepositorio;
    public Escritor(MesasRepositorio mesasRepositorio){
        this.mesasRepositorio=mesasRepositorio;
    }
    @Override
    public void run() {
        String[] mensajes ={
                "Buenas tardes",
                "Estoy en clase",
                "Nos vamos de huelga"
        };
        Random random = new Random();
        for (int i = 0; i < mensajes.length; i++) {
            mesasRepositorio.Poner(mensajes[i]);
            try {
                System.out.println("Escribo menasje");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        mesasRepositorio.Poner("Fin");
    }
}
