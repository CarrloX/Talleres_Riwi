package entity;

import java.sql.Time;
import java.util.Date;

public class vuelo {

    private int id_vuelo;

    private int id_avion;

    private String destino;

    private Date fecha_salida;

    private Time hora_salida;

    public vuelo(int id_vuelo, int id_avion, String destino, Date fecha_salida, Time hora_salida) {
        this.id_vuelo = id_vuelo;
        this.id_avion = id_avion;
        this.destino = destino;
        this.fecha_salida = fecha_salida;
        this.hora_salida = hora_salida;
    }

    public vuelo() {
    }

    public int getId_vuelo() {
        return id_vuelo;
    }

    public void setId_vuelo(int id_vuelo) {
        this.id_vuelo = id_vuelo;
    }

    public int getId_avion() {
        return id_avion;
    }

    public void setId_avion(int id_avion) {
        this.id_avion = id_avion;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public Time getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(Time hora_salida) {
        this.hora_salida = hora_salida;
    }

    @Override
    public String toString() {
        return "vuelo{" +
                "id_vuelo=" + id_vuelo +
                ", id_avion=" + id_avion +
                ", destino='" + destino + '\'' +
                ", fecha_salida=" + fecha_salida +
                ", hora_salida=" + hora_salida +
                '}';
    }
}
