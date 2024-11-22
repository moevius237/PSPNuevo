package UD2.parking;

import UD2.cafe.CofeeBar;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private List<Coche> cochesList = new ArrayList<>();

    public synchronized Coche cocheEntrar(Coche coche) {
        while (cochesList.size() >= 20) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
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
        while (!(cochesList.size() >=1)){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        cochesList.remove(co);

    }
}
