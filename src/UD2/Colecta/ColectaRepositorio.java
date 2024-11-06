package UD2.Colecta;

public class ColectaRepositorio {
    private int dineros;

    public synchronized void recolector(int recaudado){
        while (dineros > 2000) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        notifyAll();
        System.out.println("Recaude " +recaudado + " de un total de " +dineros);
        this.dineros+=recaudado;
    }
    public synchronized void robar(int quitado){
        while (dineros < 0){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        notifyAll();
        System.out.println("Quite " +quitado +" de un todal de " + dineros);
        this.dineros-=quitado;

    }
}
