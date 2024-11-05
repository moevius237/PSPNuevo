package UD2.Colecta;
/*
Se tienen varios hilos que realizan una colecta pero no se puede recoger mas dinero
una vez se ha llegado a una cantidad limite 2000 euros

Habran hilos consumidores que reciben una cantidad de dinero entre 10 y 40
a intervalos de tiempo aleatorio entre 20 y 300 ms

Habra hilos recolectore no pueden recoger dinero cunaando se ha llegado
al limite debran esperar a que los consumidores retiren dinero , si llegan al limite
tienen que esperar a que quiten dinero

3 hilos consumidores y uno recolecto
 */
public class Colectando {
    public static void main(String[] args) {
        ColectaRepositorio colectaRepositorio = new ColectaRepositorio();
        Recolecta t1 = new Recolecta(colectaRepositorio);
        Roba r1 = new Roba(colectaRepositorio);
        Roba r2 = new Roba(colectaRepositorio);
        Roba r3 = new Roba(colectaRepositorio);

        t1.start();
        r1.start();
        r2.start();
        r3.start();
    }
}
