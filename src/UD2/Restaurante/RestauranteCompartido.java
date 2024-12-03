package UD2.Restaurante;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestauranteCompartido {
    private Map<Integer,String> mesas = new HashMap<>();

    public synchronized boolean mesaDisponible(String nombre){
        while (!(mesas.size() > 30)){
                int mesa = mesas.size()+1;
                mesas.put(mesa,nombre);
                notifyAll();
                System.out.println("El cliente " + nombre + " se ha sentado en la mesa" + mesa);
                return true;

        }
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    public synchronized void vaciarMEsa(){
        while (!(mesas.size()<0)){
            System.out.println("El cliente" + mesas.get(mesas.size())+ " abandona el restaurante");
            mesas.remove(mesas.size());
            notifyAll();
        }
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
