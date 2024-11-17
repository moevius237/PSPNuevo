package UD2.cafe;

import java.util.Random;

public class CoffeeCustomer extends Thread{
    private final CofeeBar cofeeBar;
    public CoffeeCustomer(CofeeBar cofeeBar) {
        this.cofeeBar = cofeeBar;
    }

    @Override
    public void run() {
        Random r =new Random();
        while (true){
            CupOfCoffee cofeeBar1 = cofeeBar.getCafes().get(r.nextInt(1,2));
            String tipo = cofeeBar1.getTipo();
            cofeeBar.orderCofee(r.nextInt(1,100000),tipo);
        }
    }
}
