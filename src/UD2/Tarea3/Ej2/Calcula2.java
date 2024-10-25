package UD2.Tarea3.Ej2;

import java.util.Random;

public class Calcula2 extends Thread{
    private Calculadora calculadora;
    public Calcula2(Calculadora calculadora){
        this.calculadora=calculadora;
    }
    @Override
    public void run() {
        int [] suma = new int[10];
        Random random = new Random();
        for (int i = 0; i < suma.length; i++) {
            suma[i] = random.nextInt(1,10);
        }
        calculadora.calcularSuma(suma);
    }
}
