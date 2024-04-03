package controller;

import entity.Paciente;
import model.PacienteModel;

import javax.swing.*;
import java.time.LocalDate;
import java.util.List;

public class PacienteController {

    PacienteModel pacienteModel;

    public PacienteController() {
        this.pacienteModel = new PacienteModel();
    }

    public void create(String nombre, String apellidos, LocalDate fechaNacimiento, String documentoIdentidad) {
        Paciente paciente = new Paciente();
        paciente.setNombre(nombre);
        paciente.setApellidos(apellidos);
        paciente.setFechaNacimiento(fechaNacimiento);
        paciente.setDocumentoIdentidad(documentoIdentidad);

        if (pacienteModel.create(paciente)) {
            JOptionPane.showMessageDialog(null, "paciente agregado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "error");
        }
    }

    public List<Object> read() {
        return pacienteModel.read();
    }

    public void update() {

        int idPacienteToUpdate = Integer.parseInt(JOptionPane.showInputDialog("ingrese el ID del paciente para actualizar:"));
        String nombreNuevo = JOptionPane.showInputDialog("ingresa el nuevo nombre del paciente:");
        String apellidoNuevo = JOptionPane.showInputDialog("ingresa el nuevo apellido del paciente:");
        String fechaNacimientoNuevo = JOptionPane.showInputDialog("ingresa la nueva fecha de nacimiento");
        String documentoIdentidadNuevo = JOptionPane.showInputDialog("ingresa el nuevo documento de identidad:");


        Paciente pacienteToUpdate = new Paciente(idPacienteToUpdate, nombreNuevo, apellidoNuevo, LocalDate.parse(fechaNacimientoNuevo), documentoIdentidadNuevo);

        if (pacienteModel.update(pacienteToUpdate)) {
            JOptionPane.showMessageDialog(null, "información del paciente actualizada");
        } else {
            JOptionPane.showMessageDialog(null, "error al actualizar el paciente");
        }
    }

    public void delete(int idPaciente) {
        if (pacienteModel.delete(idPaciente)) {
            JOptionPane.showMessageDialog(null, "paciente eliminado exitosamente");
        } else {
            JOptionPane.showMessageDialog(null, "error al eliminar el paciente");
        }
    }
}
