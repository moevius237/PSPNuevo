package UD2.Tarea3.Ej2;

import UD2.ThreadColor;

import java.util.Random;

public class Calcula1 extends Thread {
    private Calculadora calculadora;
    int [] suma;
    public Calcula1(Calculadora calculadora,int [] suma){
        this.calculadora=calculadora;
        this.suma=suma;
    }
    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < suma.length; i++) {
            suma[i] = random.nextInt(1,10);
        }
        calculadora.calcularSuma(suma);
    }
}
