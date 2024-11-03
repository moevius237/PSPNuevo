package UD2.ThreadColorPrubea;

import UD2.ThreadColor;

import java.util.concurrent.TimeUnit;

public class Cronometro {
    private TimeUnit timeUnit;
    ThreadColor threadColor = new ThreadColor();

    public Cronometro(TimeUnit timeUnit){
        this.timeUnit = timeUnit;
    }
    public void coubntDown (int count){
        for (int i = count; i >0; i--) {
            try {
                timeUnit.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(threadColor.ANSI_BLUE + "THREAD i = " +i );
        }
    }
}
