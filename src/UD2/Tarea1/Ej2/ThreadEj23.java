package UD2.Tarea1.Ej2;

public class ThreadEj23 extends Thread{
    private ThreadEj22 threadEj22;
    public ThreadEj23(ThreadEj22 threadEj22){
        this.threadEj22=threadEj22;
    }
    @Override
    public void run() {
        try {
            threadEj22.join();
            for (int i = 11; i < 16; i++) {
                System.out.println(i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
