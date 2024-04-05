package entity;


public class Vuelo {

    private int id_vuelo;

    private int id_avion;

    private String destino;

    private String fecha_salida;

    private String hora_salida;

    private Avion avion;
    //esto es para usar una entidad ajena en un controlador distinto


    public Vuelo(String destino, String fecha_salida, String hora_salida, int id_avion,Avion avion) {
        this.id_avion = id_avion;
        this.destino = destino;
        this.fecha_salida = fecha_salida;
        this.hora_salida = hora_salida;
        this.avion = avion;
    }

    public Vuelo() {
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

    public String getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(String fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public String getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(String hora_salida) {
        this.hora_salida = hora_salida;
    }

    @Override
    public String toString() {
        return
                "ID Vuelo: " + id_vuelo +
                " ID Avion:" + id_avion +
                " Destino: " + destino +
                " Fecha de Salida: " + fecha_salida +
                " Hora de Salida: " + hora_salida;
    }
}
