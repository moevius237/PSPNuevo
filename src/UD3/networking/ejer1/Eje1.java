package UD3.networking.ejer1;

public class Eje1 {
    /**
     * Vamos a hacer un sistema de gestion de inventario un tpv
     * TPV sera un cliente
     * Servidor central
     *
     * Cada toc simulara transacciones de venta y enviara los datos al servidor
     * enviara los datos siguiendo el formato siguiente
     * leche#10
     * pan#4
     *
     * El servidor precesara las transacciones para mantener actualizado el inventario de venta
     * el servidor tiene que ser multihilo comparten un objeto con los hilos este objeto representa
     * el inventario de venta, garantizar la consistencia del inventario
     *
     * CAda tpv enviara 100 ventas de forma aleatoria entre 1 y 10
     * productos: leche , arroz , aceite, tomates, turron, jamon , mermelada, mantequilla , kebabs
     *
     */
}
