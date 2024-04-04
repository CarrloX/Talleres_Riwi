package entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class Cita {
    private int idCita;

    private int idPaciente;

    private int idMedico;

    private LocalDate fecha;

    private LocalTime hora;

    private String motivo;

    private Medico medico;

    private Paciente paciente;

    public Cita(int idCita, int idPaciente, int idMedico, LocalDate fecha, LocalTime hora, String motivo) {
        this.idCita = idCita;
        this.idPaciente = idPaciente;
        this.idMedico = idMedico;
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
    }

    public Cita(int idCita, LocalDate fecha, LocalTime hora, String motivo) {
        this.idCita = idCita;
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }


    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "idCita=" + idCita +
                ", idPaciente=" + idPaciente +
                ", idMedico=" + idMedico +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", motivo='" + motivo + '\'' +
                '}';
    }
}
