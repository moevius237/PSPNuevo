package UD2.mesas;

public class Lector extends Thread{
    private MesasRepositorio mesasRepositorio;
    public Lector(MesasRepositorio mesasRepositorio){
        this.mesasRepositorio=mesasRepositorio;
    }
    @Override
    public void run() {
        String lastMesa =" ";
        while (!lastMesa.equals("Fin")){
            lastMesa = mesasRepositorio.quitar();
            System.out.println("Mensaje leido " + lastMesa);
        }
    }
}
