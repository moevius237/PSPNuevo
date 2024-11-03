package UD2.Tarea1.ej6;

public class Ej6 {
    public static void main(String[] args) {
        ThreadEj61 threadEj61 = new ThreadEj61();
        ThreadEj62 threadEj62 = new ThreadEj62(threadEj61);
        ThreadEj63 threadEj63 = new ThreadEj63(threadEj61);
        threadEj61.start();
        threadEj62.start();
        threadEj63.start();
    }
}
