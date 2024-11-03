package UD2.Tarea1.Ej2;

public class Ej2 {
    public static void main(String[] args) {
        ThreadEj21 threadEj21 = new ThreadEj21();
        ThreadEj22 threadEj22 = new ThreadEj22(threadEj21);
        ThreadEj23 threadEj23 = new ThreadEj23(threadEj22);

        threadEj21.start();
        threadEj22.start();
        threadEj23.start();
    }
}
