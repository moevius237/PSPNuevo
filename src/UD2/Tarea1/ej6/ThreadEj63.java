package UD2.Tarea1.ej6;

public class ThreadEj63 extends Thread{
    private ThreadEj61 threadEj61;
    public ThreadEj63(ThreadEj61 threadEj61){
        this.threadEj61 = threadEj61;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            System.out.println("Muere hilo 1");
            threadEj61.interrupt();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
