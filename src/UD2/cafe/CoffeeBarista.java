package UD2.cafe;

public class CoffeeBarista extends Thread{
    private final CofeeBar cofeeBar;

    public CoffeeBarista(CofeeBar cofeeBar) {
        this.cofeeBar = cofeeBar;
    }


    @Override
    public void run() {
        while (true) {
            cofeeBar.serverCofee();
        }
    }
}
