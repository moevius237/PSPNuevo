package UD2.Tarea3.Ej2;

import java.util.Random;

public class Calcula2 extends Thread{
    private Calculadora calculadora;
    int suma[];
    public Calcula2(Calculadora calculadora,int suma []){
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
