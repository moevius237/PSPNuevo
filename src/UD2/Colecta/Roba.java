package UD2.Colecta;

import java.util.Random;

public class Roba extends Thread {
    private ColectaRepositorio colecta;

    public Roba (ColectaRepositorio colecta){
        this.colecta=colecta;
    }
    @Override
    public void run() {
        Random r = new Random();
        while (true){
            colecta.robar(r.nextInt(1,100));
        }
    }
}
