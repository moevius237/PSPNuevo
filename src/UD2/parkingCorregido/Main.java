package UD2.parkingCorregido;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        final Parking parking = new Parking();
        Random r = new Random();
        while (true){
            Thread coche = new Thread(new Coche(parking, r.nextInt(9999)+"AB"));
            coche.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
