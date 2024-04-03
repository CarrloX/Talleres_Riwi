package controller;

import entity.Medico;
import model.MedicoModel;

import javax.swing.*;
import java.util.List;

public class MedicoController {
    MedicoModel medicoModel;

    public MedicoController(){
        this.medicoModel = new MedicoModel();
    }

    public void create(String nombre, String apellidos, int idEspecialidad){
        Medico medico = new Medico();
        medico.setNombre(nombre);
        medico.setApellidos(apellidos);
        medico.setIdEspecialidad(idEspecialidad);

        if (medicoModel.create(medico)) {
            JOptionPane.showMessageDialog(null, "medico agregado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "error");
        }
    }
    public List<Object> read() {
        return medicoModel.read();
    }

    public void update() {
        int idMedicoToUpdate = Integer.parseInt(JOptionPane.showInputDialog("ingresa el ID del médico para actualizar:"));
        String nombreNuevo = JOptionPane.showInputDialog("ingresa el nuevo nombre del medico:");
        String apellidoNuevo = JOptionPane.showInputDialog("ingresa el nuevo apellido del medico:");
        int idEspecialidadNuevo = Integer.parseInt( JOptionPane.showInputDialog("ingresa la nueva especialidad del medico:"));


        Medico medicoToUpdate = new Medico();
        medicoToUpdate.setIdMedico(idMedicoToUpdate);
        medicoToUpdate.setNombre(nombreNuevo);
        medicoToUpdate.setApellidos(apellidoNuevo);
        medicoToUpdate.setIdEspecialidad(idEspecialidadNuevo);

        if (medicoModel.update(medicoToUpdate)) {
            JOptionPane.showMessageDialog(null, "información del medico actualizada");
        } else {
            JOptionPane.showMessageDialog(null, "error al actualizar el medico");
        }
    }

    public void delete(int idMedico) {
        try {
            if (medicoModel.delete(idMedico)) {
                JOptionPane.showMessageDialog(null, "medico eliminado exitosamente");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error al eliminar el medico: " + e.getMessage());
        }
    }

}
