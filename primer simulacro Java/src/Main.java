import controller.PacienteController;
import entity.Paciente;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PacienteController objPacienteController = new PacienteController();
        String option;
        do {
            option = JOptionPane.showInputDialog("""
                MENU
                1. Crear paciente
                2. Listar pacientes
                3. Actualizar pacientes
                4. Eliminar pacientes
                5. Salir
                """);
            switch (option) {
                case "1":
                    String nombrePaciente = JOptionPane.showInputDialog("ingresa el nombre del paciente");
                    String apellidosPaciente = JOptionPane.showInputDialog("ingresa los apellidos del paciente");
                    String fechaNacimientoStr = JOptionPane.showInputDialog("ingresa la fecha de nacimiento del paciente (YYYY-MM-DD)");
                    String documentoIdentidad = JOptionPane.showInputDialog("ingresa el documento de identidad del paciente");
                    try {
                        LocalDate fechaNacimiento=LocalDate.parse(fechaNacimientoStr);
                        objPacienteController.create(nombrePaciente, apellidosPaciente, fechaNacimiento, documentoIdentidad);
                    } catch (DateTimeParseException e) {
                        JOptionPane.showMessageDialog(null, "formato de fecha incorrecto. utiliza el formato YYYY-MM-DD y con guiones incluidos >:v");
                    }
                    break;
                case "2":
                    List<Object> pacientes= objPacienteController.read();
                    StringBuilder message = new StringBuilder("lista de pacientes:\n");
                    for(Object pacienteObj : pacientes){
                        if (pacienteObj instanceof Paciente paciente){
                            message.append("ID: ").append(paciente.getIdPaciente()).
                                    append(", Nombre: ").append(paciente.getNombre()).
                                    append(", Apellido: ").append(paciente.getApellidos()).
                                    append(", Fecha de Nacimiento ").append(paciente.getFechaNacimiento()).
                                    append(", Documento de Identidad ").append(paciente.getDocumentoIdentidad()).
                                    append("\n");
                        }
                    }
                    JOptionPane.showMessageDialog(null,message.toString());
                    break;
                case "3":
                    objPacienteController.update();
                    break;
                case "4":
                    int idPacienteToDelete = Integer.parseInt(JOptionPane.showInputDialog("ingresa el ID del autor para eliminar:"));
                    objPacienteController.delete(idPacienteToDelete);
                    break;
            }
        } while (!option.equals("5"));
    }
}