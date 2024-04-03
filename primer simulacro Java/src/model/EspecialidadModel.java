package model;

import database.CRUD;
import database.ConfigDB;
import entity.Especialidad;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EspecialidadModel implements CRUD {

    public boolean create(Object object) {
        Connection objConnection = null;
        boolean isCreated = false;

        Especialidad objEspecialidad = (Especialidad) object;

        try{
            objConnection = ConfigDB.openConnection();

            String sql = "INSERT INTO especialidad(nombre,descripcion, id_especialidad) VALUES (?,?,?)";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1,objEspecialidad.getNombre());
            objPrepare.setString(2,objEspecialidad.getDescricion());
            objPrepare.setInt(3, objEspecialidad.getIdEspecialidad());

            objPrepare.executeUpdate();

            ResultSet objResult = objPrepare.getGeneratedKeys();
            if (objResult.next()){
                objEspecialidad.setIdEspecialidad(objResult.getInt(1));
                isCreated = true;
            }

            objPrepare.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"error al agregar la especialidad"+e.getMessage());
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
        List<Object> especialidades = new ArrayList<>();

        try{
            String sql="SELECT * FROM especialidad;";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()) {
                int idEspecialidad = objResult.getInt("id_especialidad");
                String nombre = objResult.getString("nombre");
                String descripcion = objResult.getString("descripcion");
                Especialidad especialidad = new Especialidad(idEspecialidad,nombre,descripcion);
                especialidades.add(especialidad);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }finally {
            ConfigDB.closedConnection();
        }
        return especialidades;
    }

    @Override
    public boolean update(Object object) {
        boolean isUpdated = false;

        Connection objConnection = ConfigDB.openConnection();

        Especialidad objEspecialidad = (Especialidad) object;

        try {

            String sql = "UPDATE especialidad SET nombre = ?, descripcion = ? WHERE id_especialidad = ? " ;

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setString(1,objEspecialidad.getNombre());
            objPrepare.setString(2,objEspecialidad.getDescricion());
            objPrepare.setInt(3,objEspecialidad.getIdEspecialidad());

            int rowAffected = objPrepare.executeUpdate();

            if (rowAffected > 0) {
                isUpdated = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error al actualizar la especialidad: " + e.getMessage());
        } finally {
            ConfigDB.closedConnection();
        }

        return isUpdated;
    }

    @Override
    public boolean delete(int idEspecialidad) {
        boolean isDeleted = false;

        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "DELETE FROM especialidad WHERE id_especialidad = ?";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1, idEspecialidad);

            int rowAffected = objPrepare.executeUpdate();

            if (rowAffected > 0) {
                isDeleted = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"error al eliminar la especialidad: "+e.getMessage());
        } finally {
            ConfigDB.closedConnection();
        }

        return isDeleted;
    }
}
