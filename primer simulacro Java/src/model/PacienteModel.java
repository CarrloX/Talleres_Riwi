package model;

import database.CRUD;
import database.ConfigDB;
import entity.Paciente;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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
            JOptionPane.showMessageDialog(null,"paciente agregado correctamente");
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
        return false;
    }

    @Override
    public boolean delete(Object object) {
        return false;
    }

}
