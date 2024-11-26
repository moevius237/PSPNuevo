package UD2.parkingCorregido;

public class Parking {
    private final static int MAX = 20;
    private String [] plazas = new String[MAX];
    public synchronized int aparcar (String matricula){
        for (int i = 0; i < plazas.length; i++) {
            if (plazas[i] == null){
                plazas[i]= matricula;
                System.out.println("Se aparco la matricula" + matricula);
                return i;
            }
        }
        return -1;
    }
    public synchronized void dejarAparcamiento(String matricula){
        for (int i = 0; i < plazas.length; i++) {
            if (plazas[i] != null && plazas[i].equals(matricula)){
                plazas[i]= null;
                System.out.println("Se salio del parking" + matricula);
            }
        }
    }
}
