package UD2.bateriaCompartida;

public class Bateria {
    private int unidades;
    private final int maxEnergia =300;

    public synchronized void sumarEnergia(int suma){
        int cosa = unidades;
        if (!((cosa+=suma) >maxEnergia)){
            this.unidades+=suma;
            System.out.println("SE sumo " +suma +" de un total de "+ this.unidades );
            notifyAll();
        }else {
            System.out.println("La bateria esta llena");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public synchronized void restarEnergia(int resta){
        int cosa = unidades;
        if (!((cosa-=resta) < 0)){
            this.unidades-=resta;
            System.out.println("SE resto " +resta +" de un total de "+ this.unidades );
            notifyAll();
        }else {
            System.out.println("La bateria esta vacia");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
