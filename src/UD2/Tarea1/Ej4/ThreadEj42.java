package UD2.Tarea1.Ej4;

public class ThreadEj42 implements Runnable{
    ThreadEj41 threadEj41;
    public ThreadEj42(ThreadEj41 threadEj41){
        this.threadEj41=threadEj41;
    }
    @Override
    public void run() {
        try {
            threadEj41.join();
            System.out.println("SUma realizada con exito");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
