package controller;

import database.CRUD;
import database.ConfigDB;
import entity.Autor;
import model.AutorModel;
import model.LibroModel;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AutorController{

    AutorModel autorModel;

    public AutorController() {
        this.autorModel = new AutorModel();
    }


    public boolean insertAutor(String nombre, String nacionalidad) {
        Autor autor = new Autor();
        autor.setNombre(nombre);
        autor.setNacionalidad(nacionalidad);

        if (autorModel.insertAutor(autor)) {
            JOptionPane.showMessageDialog(null, "autor agregado correctamente");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "error");
            return false;
        }
    }


    public boolean updateAutor(int idAutor) {

        int idAutorToUpdate = Integer.parseInt(JOptionPane.showInputDialog("ingrese el ID del autor para actualizar:"));
        String nombreNuevo = JOptionPane.showInputDialog("ingresa el nuevo nombre del autor:");
        String nacionalidadNueva = JOptionPane.showInputDialog("ingrese la nueva nacionalidad del autor:");

        Autor autorToUpdate = new Autor(idAutorToUpdate, nombreNuevo, nacionalidadNueva);

        if (autorModel.updateAutor(autorToUpdate)) {
            JOptionPane.showMessageDialog(null, "información del autor actualizada");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "error al actualizar el autor");
            return false;
        }
    }



    public boolean deleteAutor(int idAutor) {
        if (autorModel.deleteAutor(idAutor)) {
            JOptionPane.showMessageDialog(null, "autor eliminado exitosamente");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "error al eliminar el autor");
            return false;
        }
    }


    public List<Autor> findAllAutores() {
        Connection objConnection = ConfigDB.openConnection();
        List<Autor> autores = new ArrayList<>();

        try {
            String sql = "SELECT * FROM Autor;";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()) {
                int idAutor = objResult.getInt("IdAutor");
                String nombre = objResult.getString("nombre");
                String nacionalidad = objResult.getString("nacionalidad");

                Autor autor = new Autor(idAutor, nombre, nacionalidad);
                autores.add(autor);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            // Cerrar la conexión
            ConfigDB.closedConnection();
        }

        return autores;
    }



}
