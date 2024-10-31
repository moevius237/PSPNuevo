package UD2.Tarea4.EJ1;

public class Tienda {
    private int totalVentas=0;

    public int getTotalVentas() {
        return totalVentas;
    }

    public synchronized void agregarVenta(int monto){
        int actual = this.totalVentas;
        this.totalVentas += monto;
        System.out.println("Mi actual de ventas es " +actual + " El monto añadido es "+ monto+ "  mi total es " + totalVentas);
    }
}
