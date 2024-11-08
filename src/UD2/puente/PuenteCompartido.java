package UD2.puente;

import java.util.ArrayList;
import java.util.List;

public class PuenteCompartido {
    private int pesoActual;
    private int personasActual;
    private static final int personasTotal = 3;
    private static final int pesoMAx = 300;
    private List<Integer> pesos = new ArrayList<>();
    public synchronized void autorizacion(int pesoNuevo){
        if (!((this.pesoActual+=pesoNuevo) >= pesoMAx)){
            if (!(this.personasActual >= personasTotal)) {
                pesos.add(pesoNuevo);
                this.personasActual += 1;
                System.out.println("Entra " + pesoNuevo + " son actualmente " + personasActual + " personas y pesan " + pesoActual);
                notifyAll();
            }
        }else {
            try {
                System.out.println("no puede entrar espera");
                this.personasActual += 1;
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public synchronized void terminaPaso(){
        if (!(this.personasActual <= 0)){
            int sale = pesos.getFirst();
            this.pesoActual-=sale;
            this.personasActual-=1;
            pesos.remove(pesos.getFirst());
            System.out.println("SALE " + sale + " son actualmente " + personasActual + " personas y pesan " + pesoActual);
            notifyAll();
        }else {
            try {
                System.out.println("Puedes pasar");
                this.personasActual-=1;
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
