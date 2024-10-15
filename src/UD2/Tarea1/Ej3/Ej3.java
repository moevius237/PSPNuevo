package UD2.Tarea1.Ej3;

public class Ej3 {
    public static void main(String[] args) {
        ThreadEj31 threadEj31 = new ThreadEj31();
        threadEj31.start();
        while (threadEj31.isAlive()){
            System.out.println("Estoy vivo");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
