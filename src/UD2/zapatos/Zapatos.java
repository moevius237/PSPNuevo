package UD2.zapatos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
- dos hilos consumidores cada hilo consumidor completar 5 pedidos
 */
public class Zapatos {
    private static final String [] pedido = {"botas","tacones","deportivos" , "botas" , "sandalias" , "zancos", "sneekers" , "crocs"};
    public static void main(String[] args) {
        Random r= new Random();
        final Almacen almacen = new Almacen();
        Runnable runan = () ->{
            synchronized (almacen){
            for (int i = 0; i < 10; i++) {
                boolean b = almacen.rebirPedidos(new Pedido(1,pedido[r.nextInt(0,6)],r.nextInt(0,25)));
                if (!b){
                    try {
                        almacen.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                almacen.notifyAll();
            }
            }
        };
        Runnable rno =() ->{
            synchronized (almacen) {
                boolean m = almacen.procesarPedido();
                if (!m){
                    try {
                        almacen.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                almacen.notifyAll();
            }
        };
        Thread t = new Thread(rno);
        Thread t3 = new Thread(rno);
        Thread t1 = new Thread(runan);
        t3.start();
        t.start();
        t1.start();
    }
}
class Pedido{
    private int id;
    private final String [] pedido;
    private int cantidad;

    public Pedido(int id, String pedido, int cantidad) {
        this.id = id;
        this.pedido = new String[]{pedido};
        this.cantidad = cantidad;
    }
}
class Almacen{
    private List<Pedido> pedidos = new ArrayList<>();
    private final int espacio = 10;

    public synchronized boolean rebirPedidos(Pedido pedido){
        while (pedidos.size() >= espacio) {
            return false;
        }
        System.out.println(pedido);
        pedidos.add(pedido);
        return true;
    }
    public synchronized boolean procesarPedido(){
        while (!(pedidos.isEmpty())){
                return true;
        }
        System.out.println("borramos " + pedidos.getFirst());
        pedidos.remove(pedidos.getFirst());
        return false;
    }
}