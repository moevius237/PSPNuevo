package UD2.Tarea1.Ej5;

public class ThreadEj52 extends Thread{
    private ThreadEj51 threadEj51;
    public ThreadEj52(ThreadEj51 threadEj51){
        this.threadEj51=threadEj51;
    }
    @Override
    public void run() {
        try {
            threadEj51.join();
            System.out.println("ESPERANDO A EJECUTARME");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
