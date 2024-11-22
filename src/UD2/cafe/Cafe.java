package UD2.cafe;

import java.util.ArrayList;
import java.util.List;

/*
Vamos a simular una cafeteria con una barra donde los productores
seran los clientes realizando los dedos de cafe y los consumidores
seran los baristas sirviendo cafe

--> CupOfCoffe representa una taza de cade cafe con un id y un tipo de cafe
tendra el metodo drink que imprime un mensaje
"El cliente esa bebiendo del cafe id y tipo"
-->Cofee bar tendra una lista de tazas de cafe
OrderCofee
ServerCofee
-->CofeeCUstmoer sonlos clientes que iden cafes de manera aleatoria
-->CofeeBarista son los baristas sirviendo cafe llamara al metodo drink
la barra de cafe caben 5 clientes y los pedidos se realizan conforme se van pidiendo
Main con 3 clientes y 3 baristas
Tipos de cafes:cortadom americano, con leche,capuchino ,solo

 2.¿Como podrias implemetar una politica de prioridad para los pedidos de cafe? Por ejemplo
 algunos clientes podrina tener una prioridad sobre otros
 IMplemente
 */
public class Cafe {
    public static void main(String[] args) {
        CupOfCoffee c1 = new CupOfCoffee(1,"capuchino");
        CupOfCoffee c2 = new CupOfCoffee(2,"cortadom");
        CupOfCoffee c3 = new CupOfCoffee(3,"americano");
        CupOfCoffee c4 = new CupOfCoffee(4,"con leche");
        CupOfCoffee c6 = new CupOfCoffee(5,"solo");
        List<CupOfCoffee> cafe = new ArrayList<>();
        cafe.add(c1);
        cafe.add(c2);
        cafe.add(c3);
        cafe.add(c4);
        cafe.add(c6);
        CofeeBar cofeeBar = new CofeeBar(cafe);
        CoffeeBarista coffeeBarista1 = new CoffeeBarista(cofeeBar);
        CoffeeBarista coffeeBarista2 = new CoffeeBarista(cofeeBar);
        CoffeeBarista coffeeBarista = new CoffeeBarista(cofeeBar);
        CoffeeCustomer coffeeCustomer2= new CoffeeCustomer(cofeeBar);
        CoffeeCustomer coffeeCustomer1 = new CoffeeCustomer(cofeeBar);
        CoffeeCustomer coffeeCustomer= new CoffeeCustomer(cofeeBar);

        coffeeBarista.start();
        coffeeBarista1.start();
        coffeeBarista2.start();
        coffeeCustomer.start();
        coffeeCustomer1.start();
        coffeeCustomer2.start();
    }

}
