package UD2.Tarea4.Ej2;
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

    public synchronized void aplicarDEscuento(int descuento){
        int actual = this.totalVentas;
        if (totalVentas < descuento){
            this.totalVentas -= descuento;
            System.out.println("Mi actual de ventas es " +actual + " El monto decontado es "+ descuento+ "  mi total es " + totalVentas);

        }
    }
}
