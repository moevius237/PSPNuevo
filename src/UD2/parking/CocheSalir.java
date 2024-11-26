package UD2.parking;

public class CocheSalir extends Thread{
    private final Parking parking;
    private final CocheEntra cocheEntra;
    public CocheSalir(Parking parking, CocheEntra cocheEntra) {
        this.parking = parking;
        this.cocheEntra = cocheEntra;
    }

    @Override
    public void run() {
        while (cocheEntra.coche1 != null){
        parking.cocheSalir(cocheEntra.coche1);
    }
    }
}
