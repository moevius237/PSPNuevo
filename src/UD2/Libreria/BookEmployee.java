package UD2.Libreria;

import java.util.Random;

public class BookEmployee extends Thread{
    private final Library library;
    private String nombre;

    public BookEmployee(Library library,String nombre) {
        this.library = library;
        this.nombre=nombre;
    }

    @Override
    public void run() {
        Random r = new Random();
        synchronized (library){
            while (library.getBooks().isEmpty()){
                try {
                    library.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            library.deliverBook();
            library.notifyAll();
        }
    }
}
