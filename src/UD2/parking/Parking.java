package UD2.parking;

import UD2.cafe.CofeeBar;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private List<Coche> cochesList = new ArrayList<>();

    public synchronized Coche cocheEntrar(Coche coche) {
        if (
                cochesList.size() >= 20) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("entra el coche "+ coche );
        cochesList.add(coche);
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        notifyAll();
        return coche;
    }

    public synchronized void cocheSalir(Coche co){
        if (!(cochesList.size() >=1)){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("sale el coche " + co);
        cochesList.remove(co);

    }
}
