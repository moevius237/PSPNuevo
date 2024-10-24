package UD2.Tarea3.Ej1;

import UD2.ThreadColor;

import java.util.Random;

public class Corredor4 extends Thread{
    private Marcador marcador;
    public Corredor4(Marcador marcador){
        this.marcador=marcador;
    }
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {


            Random random = new Random();
            int numsumar = random.nextInt(0, 11);
            marcador.agregarPuntos(numsumar);
            System.out.println(ThreadColor.ANSI_PURPLE + "EL corredor 4 añadio " + numsumar);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
