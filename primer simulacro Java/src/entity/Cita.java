package entity;

import java.sql.Time;
import java.util.Date;

public class Cita {
    private int idCita;

    private int idPaciente;

    private int idMedico;

    private Date fecha;

    private Time hora;

    private String Motivo;

    public Cita(int idCita, int idPaciente, int idMedico, Date fecha, Time hora, String motivo) {
        this.idCita = idCita;
        this.idPaciente = idPaciente;
        this.idMedico = idMedico;
        this.fecha = fecha;
        this.hora = hora;
        Motivo = motivo;
    }

    public Cita(){
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getMotivo() {
        return Motivo;
    }

    public void setMotivo(String motivo) {
        Motivo = motivo;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "idCita=" + idCita +
                ", idPaciente=" + idPaciente +
                ", idMedico=" + idMedico +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", Motivo='" + Motivo + '\'' +
                '}';
    }
}
