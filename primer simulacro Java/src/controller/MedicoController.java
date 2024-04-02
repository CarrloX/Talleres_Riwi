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

    public void create(String nombre, String apellidos){
        Medico medico = new Medico();
        medico.setNombre(nombre);
        medico.setApellidos(apellidos);

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
        
        String nombreNuevo = JOptionPane.showInputDialog("ingresa el nuevo nombre del medico:");
        String apellidoNuevo = JOptionPane.showInputDialog("ingresa el nuevo apellido del medico:");
        int idEspecialidad = Integer.parseInt( JOptionPane.showInputDialog("ingresa la nueva especialidad del medico:"));


        Medico medicoToUpdate = new Medico(nombreNuevo,apellidoNuevo,idEspecialidad);

        if (medicoModel.update(medicoToUpdate)) {
            JOptionPane.showMessageDialog(null, "información del medico actualizada");
        } else {
            JOptionPane.showMessageDialog(null, "error al actualizar el medico");
        }
    }

    public void delete(int idMedico) {
        if (medicoModel.delete(idMedico)) {
            JOptionPane.showMessageDialog(null, "medico eliminado exitosamente");
        } else {
            JOptionPane.showMessageDialog(null, "error al eliminar el medico");
        }
    }
}
