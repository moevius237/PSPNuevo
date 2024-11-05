package UD2.mesas;

public class Main {
    public static void main(String[] args) {
        final MesasRepositorio mesasRepositorio = new MesasRepositorio();

        Thread t = new Escritor(mesasRepositorio);
        Thread l = new Lector(mesasRepositorio);
        t.start();
        l.start();
    }
}
