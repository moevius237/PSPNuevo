package UD2.Sincronizar;

/**
 * Todos los objetos tienen una cosa llamada bloqueo intrenseco
 * los hilos compiten por tener ese bloqueo
 */
public class ClientesMain {
    public static void main(String[] args) {
        final BankAccount bankAccount = new BankAccount(10000,"paco");

        Thread t = new Thread(() -> bankAccount.withdraw(1000));
        Thread t1 = new Thread(() -> bankAccount.deposit(1000));
        Thread t3 = new Thread(() -> bankAccount.deposit(1000));
        Thread t2 = new Thread(() -> bankAccount.withdraw(1000));
        Thread t4 = new Thread(() -> bankAccount.nom("pablo"));

        t.start();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
