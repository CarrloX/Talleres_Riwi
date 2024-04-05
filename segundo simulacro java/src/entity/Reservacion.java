package entity;

public class Reservacion {

    private int id_reservacion;

    private int id_pasajero;

    private int id_vuelo;

    private String fecha_reservacion;

    private String asiento;

    private Pasajero pasajero;

    private Vuelo vuelo;

    public Reservacion() {
    }

    public Reservacion(int id_Pasajero, Pasajero pasajero, int prueba, Vuelo vuelo, String fecha_reservacion, String asiento) {
        this.id_pasajero= id_Pasajero;
        this.id_vuelo = prueba;
        this.fecha_reservacion = fecha_reservacion;
        this.asiento = asiento;
        this.pasajero = pasajero;
        this.vuelo = vuelo;
    }

    public int getId_reservacion() {
        return id_reservacion;
    }

    public void setId_reservacion(int id_reservacion) {
        this.id_reservacion = id_reservacion;
    }

    public int getId_pasajero() {
        return id_pasajero;
    }

    public void setId_pasajero(int id_pasajero) {
        this.id_pasajero = id_pasajero;
    }

    public int getId_vuelo() {
        return id_vuelo;
    }

    public void setId_vuelo(int id_vuelo) {
        this.id_vuelo = id_vuelo;
    }

    public String getFecha_reservacion() {
        return fecha_reservacion;
    }

    public void setFecha_reservacion(String fecha_reservacion) {
        this.fecha_reservacion = fecha_reservacion;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    @Override
    public String toString() {
        return
                "ID de Reserva: " + id_reservacion +
                " ID de Pasajero: " + id_pasajero +
                " ID de Vuelo=" + id_vuelo +
                " Fecha de reserva: " + fecha_reservacion +
                " Asiento: " + asiento + '\'' +
                '}';
    }
}
