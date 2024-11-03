package UD2.Tarea1.Ej4;

import java.util.Scanner;

public class ThreadEj41 extends Thread{
    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserta un numero");
        int numero = sc.nextInt();
        int total = 0;
        for (int i = 0; i < numero; i++) {
            total = i + total;
        }
    }
}
