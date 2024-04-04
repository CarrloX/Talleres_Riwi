import controller.CitaController;
import controller.EspecialidadController;
import controller.MedicoController;
import controller.PacienteController;
import entity.Cita;
import entity.Especialidad;
import entity.Medico;
import entity.Paciente;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PacienteController objPacienteController = new PacienteController();
        MedicoController objMedicoController = new MedicoController();
        EspecialidadController objEspecialidadController = new EspecialidadController();
        CitaController objCitaController = new CitaController();
        String menuPrincipal;
        do {
            menuPrincipal = JOptionPane.showInputDialog("""
                    MENU PRINCIPAL
                    1. Administrar Pacientes
                    2. Administrar Medicos
                    3. Administrar Especialidades
                    4. Administrar Citas
                    5. Salir
                    """);
            switch (menuPrincipal) {
                case "1":
                    String pacienteOpcion;
                    do {
                        pacienteOpcion = JOptionPane.showInputDialog("""
                                MENU
                                1. Crear paciente
                                2. Listar pacientes
                                3. Actualizar pacientes
                                4. Eliminar pacientes
                                5. Volver al Menu Principal
                                """);
                        switch (pacienteOpcion) {
                            case "1":
                                String nombrePaciente = JOptionPane.showInputDialog("ingresa el nombre del paciente");
                                String apellidosPaciente = JOptionPane.showInputDialog("ingresa los apellidos del paciente");
                                String fechaNacimientoStr = JOptionPane.showInputDialog("ingresa la fecha de nacimiento del paciente (YYYY-MM-DD)");
                                String documentoIdentidad = JOptionPane.showInputDialog("ingresa el documento de identidad del paciente");
                                try {
                                    LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr);
                                    objPacienteController.create(nombrePaciente, apellidosPaciente, fechaNacimiento, documentoIdentidad);
                                } catch (DateTimeParseException e) {
                                    JOptionPane.showMessageDialog(null, "formato de fecha incorrecto. utiliza el formato YYYY-MM-DD y con guiones incluidos >:v");
                                }
                                break;
                            case "2":
                                List<Object> pacientes = objPacienteController.read();
                                StringBuilder message = new StringBuilder("lista de pacientes:\n");
                                for (Object pacienteObj : pacientes) {
                                    if (pacienteObj instanceof Paciente paciente) {
                                        message.append("ID: ").append(paciente.getIdPaciente()).append(", Nombre: ").append(paciente.getNombre()).append(", Apellido: ").append(paciente.getApellidos()).append(", Fecha de Nacimiento ").append(paciente.getFechaNacimiento()).append(", Documento de Identidad ").append(paciente.getDocumentoIdentidad()).append("\n");
                                    }
                                }
                                JOptionPane.showMessageDialog(null, message.toString());
                                break;
                            case "3":
                                objPacienteController.update();
                                break;
                            case "4":
                                int idPacienteToDelete = Integer.parseInt(JOptionPane.showInputDialog("ingresa el ID del medico para eliminar:"));
                                objPacienteController.delete(idPacienteToDelete);
                                break;
                        }
                    } while (!pacienteOpcion.equals("5"));
                    break;
                case "2":
                    String medicoOpcion;
                    do {
                        medicoOpcion = JOptionPane.showInputDialog("""
                                MÉDICOS MENU
                                1. Crear medico
                                2. Listar medicos
                                3. Actualizar medico
                                4. Eliminar medico
                                5. Volver al menu principal
                                """);
                        switch (medicoOpcion) {
                            case "1":
                                String nombreMedico = JOptionPane.showInputDialog("ingresa el nombre del medico");
                                String apellidosMedico = JOptionPane.showInputDialog("ingresa los apellidos del paciente");
                                int idEspecialidad = Integer.parseInt(JOptionPane.showInputDialog("ingresa el ID de la especialidad del medico"));
                                objMedicoController.create(nombreMedico, apellidosMedico, idEspecialidad);
                                break;
                            case "2":
                                List<Object> medicos = objMedicoController.read();
                                StringBuilder message = new StringBuilder("lista de medicos:\n");
                                for (Object medicoObj : medicos) {
                                    if (medicoObj instanceof Medico medico) {
                                        message.append("ID: ").append(medico.getIdMedico()).
                                                append(", Nombre: ").append(medico.getNombre()).
                                                append(", Apellido: ").append(medico.getApellidos()).
                                                append(", ID_Especialidad").append(medico.getIdEspecialidad()).
                                                append("\n");
                                    }
                                }
                                JOptionPane.showMessageDialog(null, message.toString());
                                break;
                            case "3":
                                objMedicoController.update();
                                break;
                            case "4":
                                int idMedicoToDelete = Integer.parseInt(JOptionPane.showInputDialog("ingresa el ID del medico para eliminar:"));
                                objMedicoController.delete(idMedicoToDelete);
                                break;
                        }
                    } while (!medicoOpcion.equals("5"));
                    break;
                case "3":
                    String especialidadOpcion;
                    do {
                        especialidadOpcion = JOptionPane.showInputDialog("""
                                ESPECIALIDAD MENU:
                                1. Crear especialidad
                                2. Listar especialidad
                                3. Actualizar especialidad
                                4. Eliminar especialidad
                                5. Volver al menu principal
                                """);
                        switch (especialidadOpcion){
                            case "1":
                                int idEspecialidad = Integer.parseInt(JOptionPane.showInputDialog("ingresa el ID de la especialidad"));
                                String nombreEspecialidad = JOptionPane.showInputDialog("ingresa el nombre de la especialidad");
                                String descripcionEspecialidad = JOptionPane.showInputDialog("ingresa la descripcion de la especialidad");
                                objEspecialidadController.create( idEspecialidad,nombreEspecialidad, descripcionEspecialidad);
                                break;
                            case "2":
                                List<Object> especialidades = objEspecialidadController.read();
                                StringBuilder message = new StringBuilder("lista de especialidades:\n");
                                for (Object especialidadObj : especialidades) {
                                    if (especialidadObj instanceof Especialidad especialidad) {
                                        message.append("ID: ").append(especialidad.getIdEspecialidad()).
                                                append(", Nombre: ").append(especialidad.getNombre()).
                                                append(", Descripcion: ").append(especialidad.getDescricion()).
                                                append("\n");
                                    }
                                }
                                JOptionPane.showMessageDialog(null, message.toString());
                                break;
                            case "3":
                                objEspecialidadController.update();
                                break;
                            case "4":
                                int idEspecialidadToDelete = Integer.parseInt(JOptionPane.showInputDialog("ingresa el ID del medico para eliminar:"));
                                objEspecialidadController.delete(idEspecialidadToDelete);
                                break;
                        }
                    } while (!especialidadOpcion.equals("5"));
                    break;
                case "4":
                    String citaOpcion;
                    do {
                        citaOpcion = JOptionPane.showInputDialog("""
                                CITAS MENU:
                                1. Crear cita
                                2. Listar citas
                                3. Actualizar citas
                                4. Eliminar citas
                                5. Volver al menu principal
                                """);
                        switch (citaOpcion){
                            case "1":
                                String fechaCitaStr = JOptionPane.showInputDialog("ingresa la fecha de la cita (YYYY-MM-DD)");
                                String horaCitaStr = JOptionPane.showInputDialog("ingresa la hora de la cita");
                                String motivo = JOptionPane.showInputDialog("ingresa el motivo de la cita");
                                String idPacienteStr = JOptionPane.showInputDialog("ingresa el id del paciente al que le deseas asignar la cita");
                                String idMedicoStr = JOptionPane.showInputDialog("ingresa el id del medico al que le deseas asignar la cita");
                                try {
                                    LocalDate fechaCita = LocalDate.parse(fechaCitaStr);
                                    LocalTime horaCita = LocalTime.parse(horaCitaStr);
                                    int idPaciente = Integer.parseInt(idPacienteStr);
                                    int idMedico = Integer.parseInt(idMedicoStr);
                                    objCitaController.create(fechaCita,horaCita,motivo,idPaciente,idMedico);
                                } catch (DateTimeParseException e) {
                                    JOptionPane.showMessageDialog(null, "formato de fecha y/o hora incorrecta. utiliza el formato YYYY-MM-DD y con guiones incluidos >:v");
                                }
                                break;
                            case "2":
                                List<Object> citas = objCitaController.read();
                                StringBuilder message = new StringBuilder("lista de citas:\n");
                                for (Object citaObj : citas) {
                                    if (citaObj instanceof Cita cita) {
                                        message.append("ID de la cita: ").append(cita.getIdCita()).append(" ").
                                                append("Paciente: ").append(cita.getPaciente().getNombre() + (" ")).
                                                append("Medico: ").append(cita.getMedico().getNombre()).
                                                append(cita.getMedico().getApellidos()+(" ")).
                                                append("Fecha de la Cita: ").append(cita.getFecha() + (" ")).
                                                append(", Hora de la Cita: ").append(cita.getHora() + (" ")).
                                                append(", Motivo: ").append(cita.getMotivo()).
                                                append("\n ");
                                    }
                                }
                                JOptionPane.showMessageDialog(null, message.toString());
                                break;
                            case "3":
                                objCitaController.update();
                                break;
                            case "4":
                                int idCitaToDelete = Integer.parseInt(JOptionPane.showInputDialog("ingresa el ID de la cita para eliminar:"));
                                objCitaController.delete(idCitaToDelete);
                                break;
                        }
                    } while (!citaOpcion.equals("5"));
                    break;
            }
        } while (!menuPrincipal.equals("5"));
    }
}