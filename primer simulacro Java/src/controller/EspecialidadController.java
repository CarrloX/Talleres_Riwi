package controller;

import entity.Especialidad;
import model.EspecialidadModel;
import javax.swing.*;
import java.util.List;

public class EspecialidadController {
    EspecialidadModel especialidadModel;

    public EspecialidadController(){
        this.especialidadModel = new EspecialidadModel();
    }

    public void create(int idEspecialidad,String nombre, String descripcion){
        Especialidad especialidad = new Especialidad();
        especialidad.setIdEspecialidad(idEspecialidad);
        especialidad.setNombre(nombre);
        especialidad.setDescricion(descripcion);


        if (especialidadModel.create(especialidad)) {
            JOptionPane.showMessageDialog(null, "especialidad agregada correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "error");
        }
    }
    public List<Object> read() {
        return especialidadModel.read();
    }

    public void update() {
        int idEspecialidadToUpdate = Integer.parseInt(JOptionPane.showInputDialog("ingresa el ID de la especialidad para actualizar:"));
        String nombreNuevo = JOptionPane.showInputDialog("ingresa el nuevo nombre de la especialidad:");
        String descripcionNuevo = JOptionPane.showInputDialog("ingresa la nueva descripcion de la especialidad:");


        Especialidad especialidadToUpdate = new Especialidad(idEspecialidadToUpdate,nombreNuevo,descripcionNuevo);

        if (especialidadModel.update(especialidadToUpdate)) {
            JOptionPane.showMessageDialog(null, "información de la especialidad actualizada");
        } else {
            JOptionPane.showMessageDialog(null, "error al actualizar la especialidad");
        }
    }

    public void delete(int idEspecialidad) {
        try {
            if (especialidadModel.delete(idEspecialidad)) {
                JOptionPane.showMessageDialog(null, "especialidad eliminada exitosamente");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error al eliminar la especialidad: " + e.getMessage());
        }
    }

}
