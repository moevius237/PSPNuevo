package UD2.Libreria;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();
    private static final int MAX_PEDIDOS = 3;

    public List<Book> getBooks() {
        return books;
    }

    public synchronized void orderBook(Book book){
        books.add(book);
    }

    public synchronized void deliverBook(){
        books.remove(0);
    }
}
