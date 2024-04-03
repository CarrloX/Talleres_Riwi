package model;

import database.CRUD;
import database.ConfigDB;
import entity.Medico;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicoModel implements CRUD {

    public boolean create(Object object) {
        Connection objConnection = null;
        boolean isCreated = false;

        Medico objMedico = (Medico) object;

        try{
            objConnection = ConfigDB.openConnection();

            String sql = "INSERT INTO medico(nombre,apellido, id_especialidad) VALUES (?,?,?)";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1,objMedico.getNombre());
            objPrepare.setString(2,objMedico.getApellidos());
            objPrepare.setInt(3, objMedico.getIdEspecialidad());

            objPrepare.executeUpdate();

            ResultSet objResult = objPrepare.getGeneratedKeys();
            if (objResult.next()){
                objMedico.setIdMedico(objResult.getInt(1));
                isCreated = true;
            }

            objPrepare.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"error al agregar el medico"+e.getMessage());
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
        List<Object> medicos = new ArrayList<>();

        try{
            String sql="SELECT * FROM medico;";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()) {
                String nombre = objResult.getString("nombre");
                String apellidos = objResult.getString("apellido");
                int idEspecialidad = objResult.getInt("id_especialidad");
                // toca crear un nuevo objeto Medico con los argumentos especificos
                Medico medico = new Medico(nombre, apellidos, idEspecialidad);
                medicos.add(medico);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }finally {
            ConfigDB.closedConnection();
        }
        return medicos;
    }

    @Override
    public boolean update(Object object) {
        boolean isUpdated = false;

        Connection objConnection = ConfigDB.openConnection();

        Medico objMedico = (Medico) object;

        try {

            String sql = "UPDATE medico SET nombre = ?, apellido = ?";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setString(1,objMedico.getNombre());
            objPrepare.setString(2,objMedico.getApellidos());

            int rowAffected = objPrepare.executeUpdate();

            if (rowAffected > 0) {
                isUpdated = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error al actualizar el medico: " + e.getMessage());
        } finally {
            ConfigDB.closedConnection();
        }

        return isUpdated;
    }

    @Override
    public boolean delete(int idMedico) {
        boolean isDeleted = false;

        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "DELETE FROM medico WHERE id_medico = ?";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1, idMedico);

            int rowAffected = objPrepare.executeUpdate();

            if (rowAffected > 0) {
                isDeleted = true;
            }
        } catch (SQLException e) {
            JOptionPane.showInputDialog(null,"error al eliminar el medico: "+e.getMessage());
        } finally {
            ConfigDB.closedConnection();
        }

        return isDeleted;
    }
}
