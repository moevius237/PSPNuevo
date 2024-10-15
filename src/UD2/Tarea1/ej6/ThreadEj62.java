package UD2.Tarea1.ej6;

public class ThreadEj62 extends Thread{
    private ThreadEj61 threadEj61;
    public ThreadEj62 (ThreadEj61 threadEj61){
        this.threadEj61=threadEj61;
    }
    @Override
    public void run() {
        try {
            threadEj61.join();
            System.out.println("Hilo 1 Murio :C");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
