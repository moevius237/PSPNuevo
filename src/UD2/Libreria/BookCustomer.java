package UD2.Libreria;

import java.util.Random;

public class BookCustomer extends Thread{
    private final Library library;
    private String nombre;

    public BookCustomer(Library library,String nombre) {
        this.library = library;
        this.nombre=nombre;
    }

    @Override
    public void run() {
        Random r = new Random();
        synchronized (library){
            while (library.getBooks().size() == 3){
                try {
                    library.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            library.orderBook(new Book(r.nextInt(9999)+"ab","java"));
            library.notifyAll();
        }
    }
}
