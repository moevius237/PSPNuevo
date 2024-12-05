package UD2.ejExcutioner.ej1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class CuentaBanco {
    private double balance;
    private String nombre;
    //Objetos para usar en bloques sincronizados
    private final Object lockBalance = new Object();
    private final Object lockName = new Object();
    public CuentaBanco(double balance) {
        this.balance = balance;
    }
    public void setNombre(String nombre) {
        synchronized (lockName) {
            this.nombre = nombre;
            System.out.println("Se ha cambiado el nombre de la cuenta a " +
                    this.nombre);
        }
    }
    public String getNombre() {
        return nombre;
    }
    public double getBalance() {
        return balance;
    }
    public Runnable ingresar(double cantidad) {
        try {
            System.out.println("chateando con cajero");
            Thread.sleep(5000);//simulo que hablo o chateo con el cajero
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized (lockBalance) {
            double originalBalance = this.balance;
            this.balance += cantidad;
            System.out.printf("Balance actual: %.0f, ingreso de: %.0f. Nuevo balance: %.0f %n", originalBalance,
                    cantidad, balance);
        }
        return null;
    }
    public Runnable retirar(double cantidad) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized (lockBalance) {
            double originalBalance = this.balance;
            if (this.balance >= cantidad) {
                this.balance -= cantidad;
                System.out.printf("Balance actual: %.0f, retirada de: %.0f. Nuevo balance: %.0f %n", originalBalance,
                        cantidad, balance);
            } else {
                System.out.println("Fondos insuficientes");
            }
        }
        return null;
    }
}
public class Main {
    public static void main(String[] args) {
        CuentaBanco cuentaBanco = new CuentaBanco(10000);
        ExecutorService ingresar = Executors.newFixedThreadPool(3);
        ExecutorService retirar = Executors.newFixedThreadPool(2);
        ingresar.submit(() -> cuentaBanco.retirar(2500));
        ingresar.submit(() -> cuentaBanco.retirar(5000));
        ingresar.submit(() -> cuentaBanco.retirar(2500));
        ingresar.submit(() -> cuentaBanco.ingresar(5000));
        ingresar.shutdown();
        retirar.shutdown();
        while (ingresar.isTerminated()){

        }
        System.out.println("Balance final de mi cuenta: " +
                cuentaBanco.getBalance());
    }
}