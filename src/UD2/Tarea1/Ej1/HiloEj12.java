package UD2.Tarea1.Ej1;

import UD2.Tarea1.Ej1.HiloEj1;

public class HiloEj12 extends Thread{
    private HiloEj1 hiloEj1;

    public HiloEj12(HiloEj1 hiloEj1){
        this.hiloEj1=hiloEj1;
    }
    @Override
    public void run() {
        try {
            System.out.println("Dormir Hilo 1");
            Thread.sleep(3000);
            System.out.println("Interrumpir hilo 2");
            hiloEj1.interrupt();
        } catch (InterruptedException e) {
            e.getMessage();
        }
    }
}
