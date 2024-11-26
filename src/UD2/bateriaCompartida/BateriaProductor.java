package UD2.bateriaCompartida;

import java.util.Random;

public class BateriaProductor extends Thread{
    private Bateria bateria;
    public BateriaProductor(Bateria bateria){
        this.bateria=bateria;
    }
    @Override
    public void run() {
        Random r = new Random();
        while (true){
        int suma = r.nextInt(1,51);
        bateria.sumarEnergia(suma);
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }}
    }
}
package UD2.bateriaCompartida;

import java.util.Random;

public class BateriaProductor extends Thread{
    private Bateria bateria;
    public BateriaProductor(Bateria bateria){
        this.bateria=bateria;
    }
    @Override
    public void run() {
        Random r = new Random();
        while (true){
            int suma = r.nextInt(1,51);
            bateria.sumarEnergia(suma);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }}
    }
}
