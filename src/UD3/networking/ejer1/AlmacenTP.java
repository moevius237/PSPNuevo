package UD3.networking.ejer1;

import java.util.HashMap;
import java.util.Map;

public class AlmacenTP {
    private Map<String, Integer> almacen = new HashMap<>();

    public synchronized void insertarProducto(String producto, int numero){
        almacen.put(producto, almacen.getOrDefault(producto,0)+numero);
        System.out.println(almacen);
    }
}
