package UD2.tiendaElectronicos;

import java.util.ArrayList;
import java.util.List;

public class ElectronicStore {

    private List<ElectronicProduct> lista;
    private final int cantidadMax = 20;
    int cantdad =0;

    public ElectronicStore(List<ElectronicProduct> lista) {
        this.lista = lista;
    }


    private void placeOrder(String producto , int cantidad){
        for (ElectronicProduct listo : lista){
            if (listo.getNombre().equals(producto)){
                if (cantidadMax> cantidad){
                }else {
                    System.out.println("No disponemos de esa cantidad");
                }
            }else {
                System.out.println("no tenemos ese producto");
            }
        }
    }
    private void fullFillOrder()

}
