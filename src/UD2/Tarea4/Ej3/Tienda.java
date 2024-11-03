package UD2.Tarea4.Ej3;

import java.util.ArrayList;
import java.util.List;

public class Tienda {
    private int totalVentas=0;
    private int transsaciones = 0;
    private List<Integer> montosRealizados= new ArrayList<>();

    public int getTotalVentas() {
        return totalVentas;
    }

    public synchronized List<Integer> agregarVenta(int monto){
        int actual = this.totalVentas;
        this.totalVentas += monto;
        this.transsaciones += 1;
        montosRealizados.add(monto);
        if (montosRealizados.size() > 3){
            for (int i = montosRealizados.size(); i > 0; i--) {
                montosRealizados.set(i,monto);
            }
        }
        System.out.println("Mi actual de ventas es " +actual + " El monto añadido es "+ monto+ "  mi total es " + totalVentas + " y llevo un total de transacciones de " +transsaciones);
        System.out.println("MIS ULTIMAS TRES TRANSACCIONEs SON " + montosRealizados);
        return montosRealizados;
    }

    public synchronized void aplicarDEscuento(int descuento){
        int actual = this.totalVentas;
        if (totalVentas < descuento){
            this.totalVentas -= descuento;
            System.out.println("Mi actual de ventas es " +actual + " El monto decontado es "+ descuento+ "  mi total es " + totalVentas);

        }
    }
}
