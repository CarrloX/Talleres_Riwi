package entity;

public class Avion {

    private int capacidad;

    private int id_avion;

    private String modelo;

    public Avion(int capacidad, int id_avion, String modelo) {
        this.capacidad = capacidad;
        this.id_avion = id_avion;
        this.modelo = modelo;
    }

    public Avion(String modelo, int capacidad) {
        this.modelo = modelo;
        this.capacidad= capacidad;
    }

    public Avion() {
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getId_avion() {
        return id_avion;
    }

    public void setId_avion(int id_avion) {
        this.id_avion = id_avion;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return
                "Capacidad: " + capacidad +
                " Modelo: " + modelo;
    }
}
