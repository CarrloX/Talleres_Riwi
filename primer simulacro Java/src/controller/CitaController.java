package controller;

import entity.Cita;
import model.CitaModel;
import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class CitaController {

    CitaModel citaModel;

    public CitaController(){
        this.citaModel = new CitaModel();
    }

    public void create(LocalDate fechaCita, LocalTime horaCita, String motivo, int idPaciente, int idMedico){
        try {
            Cita cita = new Cita();
            cita.setFecha(fechaCita);
            cita.setHora(horaCita);
            cita.setMotivo(motivo);
            cita.setIdPaciente(idPaciente);
            cita.setIdMedico(idMedico);

            if (citaModel.create(cita)) {
                JOptionPane.showMessageDialog(null, "cita agregada correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "error al agregar la cita");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error al crear la cita: " + e.getMessage());
        }
    }

    public List<Object> read() {
        return citaModel.read();
    }

    public void update() {

        int idCitaToUpdate = Integer.parseInt(JOptionPane.showInputDialog("ingrese el ID de la cita para actualizar:"));
        String fechaNueva = JOptionPane.showInputDialog("ingresa la nueva fecha de la cita:");
        String horaNueva = JOptionPane.showInputDialog("ingresa la nueva hora de la cita:");
        String motivoNuevo = JOptionPane.showInputDialog("ingresa el nuevo motivo de la cita");

        Cita citaToUpdate = new Cita(idCitaToUpdate, LocalDate.parse(fechaNueva),LocalTime.parse(horaNueva),motivoNuevo);

        if (citaModel.update(citaToUpdate)) {
            JOptionPane.showMessageDialog(null, "información de la cita actualizada");
        } else {
            JOptionPane.showMessageDialog(null, "error al actualizar la cita");
        }
    }

    public void delete(int idCita) {
        if (citaModel.delete(idCita)) {
            JOptionPane.showMessageDialog(null, "cita eliminada exitosamente");
        } else {
            JOptionPane.showMessageDialog(null, "error al eliminar la cita");
        }
    }
}
