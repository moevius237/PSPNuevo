package UD2.bateriaCompartida;

import java.util.Random;

public class BateriaConsumidor extends Thread{
    private Bateria bateria;
    public BateriaConsumidor(Bateria bateria){
        this.bateria=bateria;
    }
    @Override
    public void run() {
        Random r = new Random();
        while (true){
        int suma = r.nextInt(1,51);
        bateria.restarEnergia(suma);
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }}
    }
}
