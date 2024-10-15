package UD2.Tarea1.Ej4;

public class Ej4 {
    public static void main(String[] args) {
        ThreadEj41 threadEj41 = new ThreadEj41();
        ThreadEj42 threadEj42 = new ThreadEj42(threadEj41);
        threadEj41.start();
        Thread thread = new Thread(threadEj42);
        thread.start();
    }
}
