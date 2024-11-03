package UD2.Tarea1.Ej5;

public class EJ5 {
    public static void main(String[] args) {
        ThreadEj51 threadEj51 = new ThreadEj51();
        ThreadEj52 threadEj52 = new ThreadEj52(threadEj51);

        threadEj51.start();
        threadEj52.start();
        //lo que sucede es que el hilo que estaba esperando empieza a ejecutarse
        // cuando se le interrumpe
    }
}
