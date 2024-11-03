package UD2.Tarea1.Ej2;

public class ThreadEj22 extends Thread{
    private ThreadEj21 threadEj21;
    public ThreadEj22(ThreadEj21 threadEj21){
        this.threadEj21=threadEj21;
    }
    @Override
    public void run() {
        try {
            threadEj21.join();
            for (int i = 6; i < 11; i++) {
                System.out.println(i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
