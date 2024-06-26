package model;

import database.CRUD;
import database.ConfigDB;
import entity.Paciente;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PacienteModel implements CRUD {

    public boolean create(Object object) {
        Connection objConnection = null;
        boolean isCreated = false;

        Paciente objPaciente = (Paciente) object;

        try{
            objConnection = ConfigDB.openConnection();

            String sql = "INSERT INTO paciente(nombre,apellido,fecha_nacimiento,documento_identidad) VALUES (?,?,?,?)";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1,objPaciente.getNombre());
            objPrepare.setString(2,objPaciente.getApellidos());
            objPrepare.setObject(3,objPaciente.getFechaNacimiento());
            objPrepare.setString(4,objPaciente.getDocumentoIdentidad());

            objPrepare.executeUpdate();

            ResultSet objResult = objPrepare.getGeneratedKeys();
            if (objResult.next()){
                objPaciente.setIdPaciente(objResult.getInt(1));
                isCreated = true;
            }

            objPrepare.close();
        }catch (Exception e){
        JOptionPane.showMessageDialog(null,"error al agregar el paciente"+e.getMessage());
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
        List<Object> pacientes = new ArrayList<>();

        try{
            String sql="SELECT * FROM paciente;";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()){
                int idPaciente = objResult.getInt("id_paciente");
                String nombre = objResult.getString("nombre");
                String apellidos = objResult.getString("apellido");
                String documentoIdentidad = objResult.getString("documento_identidad");
                java.sql.Date fechaNacimientoSql = objResult.getDate("fecha_nacimiento");
                LocalDate fechaNacimiento = fechaNacimientoSql.toLocalDate();
                Paciente paciente = new Paciente(idPaciente,nombre,apellidos,fechaNacimiento,documentoIdentidad);
                pacientes.add(paciente);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }finally {
            ConfigDB.closedConnection();
        }
        return pacientes;
    }

    @Override
    public boolean update(Object object) {
        boolean isUpdated = false;

        Connection objConnection = ConfigDB.openConnection();

        Paciente objPaciente = (Paciente) object;

        try {

            String sql = "UPDATE paciente SET nombre = ?, apellido = ?, documento_identidad = ?, fecha_nacimiento= ?";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setString(1,objPaciente.getNombre());
            objPrepare.setString(2,objPaciente.getApellidos());
            objPrepare.setString(3,objPaciente.getDocumentoIdentidad());
            objPrepare.setObject(4,objPaciente.getFechaNacimiento());

            int rowAffected = objPrepare.executeUpdate();

            if (rowAffected > 0) {
                isUpdated = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error al actualizar el paciente: " + e.getMessage());
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
            String sql = "DELETE FROM paciente WHERE id_paciente = ?";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1, object);

            int rowAffected = objPrepare.executeUpdate();

            if (rowAffected > 0) {
                isDeleted = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error al eliminar el autor: " + e.getMessage());
        } finally {
            ConfigDB.closedConnection();
        }

        return isDeleted;
    }
}
