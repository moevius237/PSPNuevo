package UD2.Restaurante;

public class Cliente extends Thread {
    private final RestauranteCompartido restauranteCompartido;
    private final String nombre;

    public Cliente(RestauranteCompartido restauranteCompartido, String nombre) {
        this.restauranteCompartido = restauranteCompartido;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        boolean b = false;
        do {
            System.out.println("El cliente " + nombre + " entrara");
            b = restauranteCompartido.mesaDisponible(nombre);
            if (!b){
                break;
            }else {
                System.out.println("El cliente " + nombre + " DEbe esperar");
            }
            try {
                System.out.println("El cliente " + nombre+ " esta disfrutando de un manjar");
                Thread.sleep(3000);
                restauranteCompartido.vaciarMEsa();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while (!b);

    }
}
