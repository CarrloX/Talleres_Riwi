package model;
import database.CRUD;
import database.ConfigDB;
import entity.Autor;
import java.sql.SQLException;


import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AutorModel implements CRUD {

    @Override
    public boolean insertAutor(Autor autor) {
        Connection objConnection = null;
        boolean isInserted = false;

        try {
            objConnection = ConfigDB.openConnection();

            String sql = "INSERT INTO Autor(nombre, nacionalidad) VALUES (?, ?)";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1, autor.getNombre());
            objPrepare.setString(2, autor.getNacionalidad());

            objPrepare.executeUpdate();

            ResultSet objResult = objPrepare.getGeneratedKeys();
            if (objResult.next()) {
                autor.setIdAutor(objResult.getInt(1));
                isInserted = true;
            }

            objPrepare.close();
            JOptionPane.showMessageDialog(null, "autor agregado correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error al agregar el autor: " + e.getMessage());
        } finally {
            if (objConnection != null) {
                ConfigDB.closedConnection();
            }
        }
        return isInserted;
    }




    @Override
    public boolean updateAutor(Autor autor) {

        boolean isUpdated = false;

        Connection objConnection = ConfigDB.openConnection();

        try {

            String sql = "UPDATE Autor SET nombre = ?, nacionalidad = ? WHERE IdAutor = ?";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setString(1, autor.getNombre());
            objPrepare.setString(2, autor.getNacionalidad());
            objPrepare.setInt(3, autor.getIdAutor());

            int rowAffected = objPrepare.executeUpdate();

            if (rowAffected > 0) {
                isUpdated = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error al actualizar el autor: " + e.getMessage());
        } finally {
            ConfigDB.closedConnection();
        }

        return isUpdated;
    }



    @Override
    public boolean deleteAutor(int idAutor) {
        boolean isDeleted = false;

        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "DELETE FROM Autor WHERE IdAutor = ?";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1, idAutor);

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


    @Override
    public List<Object> findAllAutores() {
        Connection objConnection = ConfigDB.openConnection();
        List<Object> autores = new ArrayList<>();

        try{
            String sql = "SELECT * FROM Autor;";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()){
                int idAutor = objResult.getInt("IdAutor");
                String nombre = objResult.getString("nombre");
                String nacionalidad = objResult.getString("nacionalidad");

                Autor autor = new Autor(idAutor, nombre, nacionalidad);
                autores.add(autor);
            }

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }finally {
            ConfigDB.closedConnection();
        }

        return autores;
    }

}
