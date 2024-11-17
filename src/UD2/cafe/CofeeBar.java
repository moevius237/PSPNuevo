package UD2.cafe;

import java.util.List;

public class CofeeBar {
    private List<CupOfCoffee> cafes;

    public List<CupOfCoffee> getCafes() {
        return cafes;
    }

    public synchronized void orderCofee(int id , String tipo){
        if (cafes.size() < 5){
            CupOfCoffee cafe = new CupOfCoffee(id,tipo);
            cafes.add(cafe);
            System.out.println("Cafe añadido" + id + " de " + tipo);
            notifyAll();
        }else {
            System.out.println("LA barra esta llena");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("La barra se libero");
            CupOfCoffee cafe = new CupOfCoffee(id,tipo);
            cafes.add(cafe);
            System.out.println("Cafe añadido" + id + " de " + tipo);
        }
    }

    public void serverCofee(){
        if (cafes.size()>=0 ){
            cafes.remove(cafes.getFirst());
            System.out.println("cafe servido " + cafes.getFirst().toString());
            notifyAll();
        }else {
            System.out.println("No hay ningun cafe para servir");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public CofeeBar(List<CupOfCoffee> cafes) {
        this.cafes = cafes;
    }
}
