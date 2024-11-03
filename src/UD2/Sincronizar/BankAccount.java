package UD2.Sincronizar;

/**
 * Interferencia entre hilos --> heap(se guardan los objetos y sus datos)
 * Sincronización --> controla el acceso a los objetos compartidos
 */
public class BankAccount {
    private double balance;
    private String name;

    private final Object blockBalance = new Object();
    private final Object blockName= new Object();

    public BankAccount (double balance,String name){
        this.balance=balance;
        this.name=name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }
    public void deposit(double amount){
        try {
            System.out.println("HAblando con el cajero");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized (this) {
            double actual = this.balance;
            this.balance += amount;
            System.out.printf("Balance actual %.0f, Ingreso de %.0f , Nuevo balance; %.0f %n", actual, amount, this.balance);
        }
    }
    public synchronized void withdraw(double amount){
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        double actual = this.balance;
        if (this.balance <= actual){
            this.balance -= amount;
            System.out.printf("Balance actual %.0f, SACAMOS de %.0f , Nuevo balance; %.0f %n",actual,amount,this.balance);
        }else {
            System.out.println("FONDOS INSUFICIENTES");
        }

    }
}
