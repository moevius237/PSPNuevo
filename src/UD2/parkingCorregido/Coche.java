package UD2.parkingCorregido;

public class Coche implements Runnable{

    private final Parking parking;
    private final String matricula;

    public Coche(Parking parking, String matricula){
        this.parking=parking;
        this.matricula=matricula;
    }

    @Override
    public void run() {
        int aparcar = -1;
        while (aparcar == -1) {
            synchronized (parking){
            aparcar = parking.aparcar(matricula);
            if (aparcar == -1) {
                try {
                    parking.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            }
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized (parking){
            parking.dejarAparcamiento(matricula);
            parking.aparcar(matricula);
        }
    }
}
