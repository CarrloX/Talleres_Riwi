package model;

import database.CRUD;
import database.ConfigDB;
import entity.Cita;
import entity.Medico;
import entity.Paciente;

import javax.swing.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class CitaModel implements CRUD {

    public boolean create(Object object) {
        Connection objConnection = null;
        boolean isCreated = false;

        Cita objCita = (Cita) object;

        try{
            objConnection = ConfigDB.openConnection();

            String sql = "INSERT INTO cita(fecha_cita,hora_cita,id_medico,id_paciente,motivo) VALUES (?,?,?,?,?)";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setObject(1,objCita.getFecha());
            objPrepare.setObject(2, objCita.getHora());
            objPrepare.setInt(3,objCita.getIdMedico());
            objPrepare.setInt(4,objCita.getIdPaciente());
            objPrepare.setString(5,objCita.getMotivo());

            objPrepare.executeUpdate();

            ResultSet objResult = objPrepare.getGeneratedKeys();
            if (objResult.next()){
                objCita.setIdCita(objResult.getInt(1));
                isCreated = true;
            }

            objPrepare.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"error al agregar la cita"+e.getMessage());
        }finally {
            if (objConnection !=null){
                ConfigDB.closedConnection();
            }
        }
        return isCreated;
    }

    @Override
    public List<Object> read() {
        Connection objConnection = ConfigDB.openConnection();
        List<Object> citas = new ArrayList<>();

        try{
            String sql= """
                    SELECT * FROM cita
                    INNER JOIN paciente ON paciente.id_paciente = cita.id_paciente
                    INNER JOIN medico ON medico.id_medico = cita.id_medico;""";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()){
                Medico medico = new Medico();
                Paciente paciente = new Paciente();

                int idCita = objResult.getInt("id_cita");
                int idMedico = objResult.getInt("id_medico");
                int idPaciente = objResult.getInt("id_paciente");
                Date fechaCitaSql = objResult.getDate("fecha_cita");
                LocalDate fechaCita = fechaCitaSql.toLocalDate();
                Time horaCitasql = objResult.getTime("hora_cita");
                LocalTime horaCita = horaCitasql.toLocalTime();
                String motivo = objResult.getString("motivo");
                String nombreMedico = objResult.getString("medico.nombre");
                String apellidoMedico = objResult.getString("medico.apellido");
                String nombrePaciente = objResult.getString("paciente.nombre");
                Cita cita = new Cita(idCita,idMedico,idPaciente,fechaCita,horaCita,motivo);
                medico.setNombre(nombreMedico);
                medico.setApellidos(apellidoMedico);
                paciente.setNombre(nombrePaciente);


                cita.setMedico(medico);
                cita.setPaciente(paciente);

                citas.add(cita);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }finally {
            ConfigDB.closedConnection();
        }

        System.out.println(citas);
        return citas;
    }

    @Override
    public boolean update(Object object) {
        boolean isUpdated = false;

        Connection objConnection = ConfigDB.openConnection();

        Cita objCita = (Cita) object;

        try {

            String sql = "UPDATE cita SET fecha_cita = ?, hora_cita = ?, motivo = ? WHERE id_cita= ? ";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setDate(1,java.sql.Date.valueOf(objCita.getFecha()));
            objPrepare.setTime(2,java.sql.Time.valueOf(objCita.getHora()));
            objPrepare.setString(3,objCita.getMotivo());
            objPrepare.setInt(4,objCita.getIdCita());

            int rowAffected = objPrepare.executeUpdate();

            if (rowAffected > 0) {
                isUpdated = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error al actualizar la cita: " + e.getMessage());
        } finally {
            ConfigDB.closedConnection();
        }

        return isUpdated;
    }

    @Override
    public boolean delete(int object) {
        boolean isDeleted = false;

        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "DELETE FROM cita WHERE id_cita = ?";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1, object);

            int rowAffected = objPrepare.executeUpdate();

            if (rowAffected > 0) {
                isDeleted = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error al eliminar la cita: " + e.getMessage());
        } finally {
            ConfigDB.closedConnection();
        }

        return isDeleted;
    }
}
