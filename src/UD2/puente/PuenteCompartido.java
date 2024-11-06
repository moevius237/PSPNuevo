package UD2.puente;

import java.util.ArrayList;
import java.util.List;

public class PuenteCompartido {
    private int pesoActual;
    private int personasActual;
    private final int personasTotal = 3;
    private final int pesoMAx = 300;
    private List<Integer> pesos = new ArrayList<>();
    public synchronized void autorizacion(int pesoNuevo){
        if (!((pesoActual+=pesoNuevo) >= pesoMAx)){
            if (!(personasActual >= personasTotal)) {
                pesos.add(pesoNuevo);
                this.personasActual += 1;
                System.out.println("Entra " + pesoNuevo + " son actualmente " + personasActual + " personas y pesan " + pesoActual);
                notifyAll();
            }
        }else {
            try {
                System.out.println("no puede entrar espera");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public synchronized void terminaPaso(){
        if (!(personasActual <= 0)){
            int sale = pesos.getFirst();
            this.pesoActual-=sale;
            this.personasActual-=1;
            pesos.remove(pesos.getFirst());
            System.out.println("SALE " + sale + " son actualmente " + personasActual + " personas y pesan " + pesoActual);
            notifyAll();
        }else {
            try {
                System.out.println("Puedes pasar");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
