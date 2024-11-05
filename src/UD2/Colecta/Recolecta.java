package UD2.Colecta;

import java.util.Random;

public class Recolecta extends Thread{
    private ColectaRepositorio colecta;

    public Recolecta (ColectaRepositorio colecta){
        this.colecta=colecta;
    }

    @Override
    public void run() {
        Random r = new Random();
        while (true){
            colecta.recolector(r.nextInt(100,501));
            try {
                Thread.sleep(r.nextInt(20,300));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
