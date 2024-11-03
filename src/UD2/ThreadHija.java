package UD2;

public class ThreadHija  extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(0);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.getStackTrace();
            }
        }
    }
}
