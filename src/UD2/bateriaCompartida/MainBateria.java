package UD2.bateriaCompartida;

public class MainBateria {
    public static void main(String[] args) {

        Bateria bateria = new Bateria();
        BateriaProductor b1 = new BateriaProductor(bateria);
        BateriaProductor b2 = new BateriaProductor(bateria);
        BateriaProductor b3 = new BateriaProductor(bateria);
        BateriaConsumidor b4 = new BateriaConsumidor(bateria);
        b1.start();
        b2.start();
        b3.start();
        b4.start();
    }
}
