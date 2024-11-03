package UD2.Tarea4.Ej3;

import java.util.ArrayList;
import java.util.List;

public class Tienda {
    private int totalVentas = 0;
    private int transsaciones = 0;
    private List<Integer> montosRealizados = new ArrayList<>();

    public int getTotalVentas() {
        return totalVentas;
    }

    public void agregarVenta(int monto) { //No he conseguido que me funcione , no se como sincronizar esto correctamente
        int actual = this.totalVentas;
        this.totalVentas += monto;
        this.transsaciones += 1;
        synchronized (montosRealizados){
        if (montosRealizados.size() >= 4) {
            for (int i = montosRealizados.size(); i > 0; i--) {
                montosRealizados.set(i, monto);
            }
        } else {
            montosRealizados.add(monto);
        }
        System.out.println("Mi actual de ventas es " +actual + " El monto añadido es "+ monto+ "  mi total es " + totalVentas + " y llevo un total de transacciones de " +transsaciones);
        System.out.println("MIS ULTIMAS TRES TRANSACCIONEs SON " + montosRealizados);
    }
    }

    public synchronized void aplicarDEscuento(int descuento){
        int actual = this.totalVentas;
        if (totalVentas < descuento){
            this.totalVentas -= descuento;
            System.out.println("Mi actual de ventas es " +actual + " El monto decontado es "+ descuento+ "  mi total es " + totalVentas);

        }
    }
}
