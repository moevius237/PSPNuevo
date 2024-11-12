package UD2.tiendaElectronicos;

public class ElectronicProduct {
    private String nombre;
    private double precio;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public ElectronicProduct (String nombre, double precio){
        this.nombre=nombre;
        this.precio=precio;
    }

    private void readToDeliver(){

    }
}
