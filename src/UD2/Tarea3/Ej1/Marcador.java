package UD2.Tarea3.Ej1;

public class Marcador {
    static Marcador marcador = new Marcador();
    private final int puntosMAX = 50;
    static Corredor1 corredor1 = new Corredor1(marcador);
    static Corredor2 corredor2 = new Corredor2(marcador);
    static Corredor3 corredor3 = new Corredor3(marcador);
    static Corredor4 corredor4 = new Corredor4(marcador);
    public static void main(String[] args) {
        corredor1.start();
        corredor2.start();
        corredor3.start();
        corredor4.start();
        //LO que sucede es que estan todos interfiriendose entre si y haciendo que no funcione bien
        //Hacer que cada uno tuviera su propio marcador o sincronizar el metodo agregar puntos
    }
    public void agregarPuntos(int puntos){
        int puntoss = 0;
        puntoss = puntos+puntoss;
        System.out.println("HAy esots puntos "+ puntoss);
        if (puntoss > puntosMAX){
            System.out.println("YA NO MAS");
            corredor1.interrupt();
            corredor2.interrupt();
            corredor3.interrupt();
            corredor4.interrupt();

        }

    }
}
