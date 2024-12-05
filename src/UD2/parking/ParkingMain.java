package UD2.parking;

/**
 * Se tiene un parking con 20 plazas numeradas del 1 al 20
 * intentan acceder coches continuamente la entrada de coches se debe simular entre 1 sec
 * y 3 sec los cochews son los hilos cada coche se crea con una matricula distinta y cada coche
 * intenta acceso al aparcamiento indicando su matricula que queda registrada si hay aparcamiento
 * se le asigna plaza y si no hay plaza libre debera esperar
 * Si hay aparcamiento el coche estara en la plaza y estara 5 sec espera
 * despues de este tiempo abandona el aparcamiento
 *
 * Tenemos que imprimir estos mensqajes
 * El siguiente coche intentara entrar en x segundos
 * el coche con matricula X debe esperar
 * El coche X ha aparcado en la plaza X
 * El coche X ha abandonado el aparcamiento
 */
public class ParkingMain {
    public static void main(String[] args) {
        Parking parking = new Parking();
        CocheEntra cocheEntra = new CocheEntra(parking);
        CocheSalir cocheSalir = new CocheSalir(parking,cocheEntra);
        cocheEntra.start();
        cocheSalir.start();
    }
}
