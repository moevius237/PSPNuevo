package UD2.Tarea;

import com.sun.tools.javac.Main;
//Creamos hilo que cuento del 1 al 100 y lo llamamos
public class Ej1 {
    public static void main(String[] args) {
        CountThread countThread = new CountThread();
        countThread.setName("MONDONGO");
        countThread.start();

    }
}
