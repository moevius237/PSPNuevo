package UD2.Tarea;

public class CountThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 101; i++) {
            System.out.println(i);
        }
    }
}
