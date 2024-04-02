package controller;

import database.ConfigDB;
import entity.Paciente;
import model.PacienteModel;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PacienteController {

    PacienteModel pacienteModel;

    public PacienteController(){
        this.pacienteModel = new PacienteModel();
    }

    public boolean createPaciente(String nombre, String apellidos, LocalDate fechaNacimiento, String documentoIdentidad){
        Paciente paciente = new Paciente();
        paciente.setNombre(nombre);
        paciente.setApellidos(apellidos);
        paciente.setFechaNacimiento(fechaNacimiento);
        paciente.setDocumentoIdentidad(documentoIdentidad);

        if (pacienteModel.create(paciente)) {
            JOptionPane.showMessageDialog(null, "paciente agregado correctamente");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "error");
            return false;
        }
    }
    public List<Object> read() {
        return pacienteModel.read();
    }
}
