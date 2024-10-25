package UD2.Tarea3.Ej2;

import UD2.ThreadColor;

import java.util.Arrays;

public class Calculadora {
    public static Calculadora calculadora = new Calculadora();
    static Calcula1 calcula1 = new Calcula1(calculadora);
    static Calcula2 calcula2 = new Calcula2(calculadora);
    static Calcula3 calcula3 = new Calcula3(calculadora);
    public static void main(String[] args) {
        calcula1.start();
        calcula2.start();
        calcula3.start();
    }
    public void calcularSuma(int [] nume){
        int total = 0;
        for (int i = 0; i < nume.length; i++) {
            total = total+ nume[i];
            try {
                Thread.currentThread().sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

        if (Thread.currentThread().equals(calcula1)){
            System.out.println(ThreadColor.ANSI_PURPLE + "EL array es " + Arrays.toString(nume) + " el total es " +total);
            } else if (Thread.currentThread().equals(calcula2)) {
            System.out.println(ThreadColor.ANSI_GREEN+ "EL array es " + Arrays.toString(nume) + " el total es " +total);
        } else if (Thread.currentThread().equals(calcula3)) {
            System.out.println(ThreadColor.ANSI_RED+ "EL array es " + Arrays.toString(nume) + " el total es " +total);
        }
    }
    }

