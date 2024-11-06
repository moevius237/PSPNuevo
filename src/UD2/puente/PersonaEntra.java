package UD2.puente;

import java.util.Random;

public class PersonaEntra extends Thread{
    private PuenteCompartido puenteCompartido;

    public PersonaEntra (PuenteCompartido puenteCompartido){
        this.puenteCompartido=puenteCompartido;
    }

    @Override
    public void run() {
        Random r = new Random();
        while (true){
        int pesoPersonaNuevo = r.nextInt(40,121);
        try {
            Thread.sleep(r.nextInt(1000,5001));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
            System.out.println("Entra " + pesoPersonaNuevo);
        puenteCompartido.autorizacion(pesoPersonaNuevo);
    }
    }
}
