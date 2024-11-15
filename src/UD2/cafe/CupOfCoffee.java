package UD2.cafe;

public class CupOfCoffee {
    private int id;
    private String tipo;

    private void DrinkCofee(int id , String tipo){
        System.out.println("EL cliente esta bebiendo el cafe "+ id + " de " + tipo);
    }

    @Override
    public String toString() {
        return "CupOfCoffee{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                '}';
    }

    public CupOfCoffee(int id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
