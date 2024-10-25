package UD2.Tarea3.Ej2;

import java.util.Random;

public class Calcula3 extends Thread{
    private Calculadora calculadora;
    public Calcula3(Calculadora calculadora){
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
