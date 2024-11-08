package UD2.zapatos;
/*
Consumer/Producer para un almacen de zapatos

El codigo del productor generara pedidos y los enviara al almacen para
que este los procese.
El consumiror procesara estos pedidos en orden FIFO

Tendremos que crear las siguientes clases
-Pedido,incluye identificador de pedido , tipo de zapato y la cantidad del pedido
Almacen tendra una lista de pedido como maximo mi almacen podra almacenar 10 pedidos
--> en almacen tendremos los metodos
-> recibirPedidos: recibe un pedido y lo añade a la lista
-> completarPedido: procesa el pedido, es decir lo quita de la lista(FIFO)


EN mi clase Main:
- un array de tipos de zapatos static final : botas , tacones, deportivos , botas , sandalias , zancos, sneekers , crocs
- un hilo productor que generara 10 pedidos, id aleatorio, tipo zapatos aleatorio continua aleatorio: 20-25
-dos hilos consumidores cada hilo consumidor completar 5 pedidos
 */
public class Zapatos {
    public static void main(String[] args) {

    }
}
