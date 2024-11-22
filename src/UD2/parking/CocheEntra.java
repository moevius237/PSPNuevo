package UD2.parking;

import java.util.Random;

public class CocheEntra extends Thread{
    private final Parking parking;
    public Coche coche1;

    public CocheEntra(Parking parking) {
        this.parking = parking;
    }

    @Override
    public void run() {
        Random r = new Random();
        int matricula = r.nextInt(1,1000);
        Coche coche = new Coche(matricula);
        coche1 = parking.cocheEntrar(coche);
    }
}
