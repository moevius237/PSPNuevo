package UD2.cafe;

import java.util.Random;

public class CoffeeCustomer extends Thread{
    private final CofeeBar cofeeBar;
    private final String tipos[];
    public CoffeeCustomer(CofeeBar cofeeBar, String[] tipos) {
        this.cofeeBar = cofeeBar;
        this.tipos = tipos;
    }

    @Override
    public void run() {
        Random r =new Random();
        while (true){
            cofeeBar.orderCofee(r.nextInt(1,100000),tipos[r.nextInt(0,7)]);
        }
    }
}
