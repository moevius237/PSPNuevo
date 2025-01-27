package UD2.puente;

import java.util.Random;

public class PersonaSale extends Thread{
    private PuenteCompartido puenteCompartido;

    public PersonaSale (PuenteCompartido puenteCompartido){
        this.puenteCompartido=puenteCompartido;
    }

    @Override
    public void run() {
        Random r = new Random();
        while (true) {
            try {
                Thread.sleep(r.nextInt(10000, 20001));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        //    puenteCompartido.terminaPaso();
        }
    }
}
