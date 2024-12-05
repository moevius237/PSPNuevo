package UD2.Libreria;

public record Book(String isbn, String titulo) {

    public void read(){
        System.out.println("El cliente ha recibido el libro " + titulo + " con isbn "+ isbn);
    }
}
