package UD2.Restaurante;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
Imagina un restaurante con adoro maximo de 30 personas con 30 mesas numeradas del 1 al 30
Los clientes llegan continuamente y el acceso al restaurante se simula cada cierto entre 800
y 2000 ms van llegando clientes
Los hilos son los clientes , un cliente llega al restaurante
e intenta obtener mesa indicando su nonbre , el cual queda registrado
si hay una mesa libre asignandole ese numero de mesa
En caso contrario (no hay mesa) , el cliente debe esperar
Cuando hay mesa se simula el tiempo que pasa el cliente comiendo
entre 1 y 5s despues abandona el restaurante
Suponemos que hay una mesa por cliente
Mensajes
-El siguiente cliente entrara en Xs
-El cliente NOMBRE debe esperar
-El cliente Nombre se ha sentado en la mesa MESA
-El cliente esta disfrutando de un manjar
-El cliente abandona el restaurante
¿Porque no se muestran todos los mensajes?Corrigelo
¿Como se podria mejorar el programa para manejar situaciones de congestion o alta demanda en el restaurante?
 */
public class Restaurante {
    public static void main(String[] args) {
        List<String> lista = new ArrayList<>();
        lista.add("pepito");
        lista.add("Manolo");
        lista.add("patri");
        lista.add("Pablo");
        lista.add("Juanito");
        lista.add("Albertito");
        lista.add("Luffy");
        lista.add("Vegetta");
        lista.add("Goku");
        lista.add("Kakarotto");
        lista.add("Yang kai");

        RestauranteCompartido restauranteCompartido = new RestauranteCompartido();
        Random r = new Random();

        while (true) {
            Cliente cliente = new Cliente(restauranteCompartido,lista.get(r.nextInt(1,lista.size())));
            cliente.start();
            try {
                Thread.sleep(r.nextInt(200,3000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
