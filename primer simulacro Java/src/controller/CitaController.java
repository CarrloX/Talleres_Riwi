package controller;

import entity.Cita;
import model.CitaModel;
import javax.swing.*;
import java.sql.Time;
import java.util.List;

public class CitaController {

    CitaModel citaModel;

    public CitaController(){
        this.citaModel = new CitaModel();
    }

    public void create(Object fechaCita, Time horaCita, String motivo){
        Cita cita = new Cita();
        cita.getFecha(fechaCita);
        cita.getHora(horaCita);
        cita.getMotivo(motivo);

        if (citaModel.create(cita)) {
            JOptionPane.showMessageDialog(null, "cita agregada correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "error");
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

        Cita citaToUpdate = new Cita(idCitaToUpdate, fechaNueva,horaNueva,motivoNuevo);

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
