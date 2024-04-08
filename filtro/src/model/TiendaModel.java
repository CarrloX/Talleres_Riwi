package model;

import database.CRUD;
import database.ConfigDB;
import entity.Tienda;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class TiendaModel implements CRUD {
    @Override
    public Object create(Object obj) {

        Connection objConnection = ConfigDB.openConnection();

        Tienda objTienda = (Tienda) obj;

        try {
            String sql = "INSERT INTO tienda (nombre,ubicacion) VALUES (?,?);";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1, objTienda.getNombre());
            objPrepare.setString(2, objTienda.getUbicacion());

            objPrepare.execute();

            ResultSet objResult = objPrepare.getGeneratedKeys();

            while (objResult.next()) {
                objTienda.setId_tienda(objResult.getInt(1));
            }

            JOptionPane.showMessageDialog(null, "la tienda fue agregada correctamente");
        } catch (SQLException e) {
            System.out.println("error" + e.getMessage());
        }
        ConfigDB.closedConnection();
        return objTienda;
    }

    @Override
    public List<Object> read() {

        List<Object> listaTienda = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "SELECT * FROM  tienda;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()) {
                Tienda objTienda = new Tienda();

                objTienda.setId_tienda(objResult.getInt("id_tienda"));
                objTienda.setNombre(objResult.getString("nombre"));
                objTienda.setUbicacion(objResult.getString("ubicacion"));

                listaTienda.add(objTienda);
            }
        } catch (SQLException e) {
            System.out.println("error" + e.getMessage());
        }

        ConfigDB.closedConnection();
        return listaTienda;
    }

    @Override
    public boolean update(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Tienda objTienda = (Tienda) obj;

        boolean isUpdated=false;

        try {
            String sql = "UPDATE tienda SET nombre = ?, ubicacion = ? WHERE id_tienda=?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setString(1,objTienda.getNombre());
            objPrepare.setString(2,objTienda.getUbicacion());
            objPrepare.setInt(3,objTienda.getId_tienda());

            int totalRowAffected = objPrepare.executeUpdate();

            if (totalRowAffected > 0){
                isUpdated=true;
                JOptionPane.showMessageDialog(null,"la tienda fue actualizada correctamente");
            }
        }catch (SQLException e){
            System.out.println("error"+ e.getMessage());
        }
        ConfigDB.closedConnection();
        return isUpdated;
    }


    @Override
    public boolean delete(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Tienda objTienda = (Tienda) obj;

        boolean isDeleted = false;

        try {
            String sql = "DELETE FROM tienda  WHERE id_tienda = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1, objTienda.getId_tienda());

            int totalAffectedRows = objPrepare.executeUpdate();

            if (totalAffectedRows > 0) {
                isDeleted = true;

                JOptionPane.showMessageDialog(null, "se ha eliminado la tienda correctamente");
            }
        } catch (SQLException e) {
            System.out.println("error" + e.getMessage());
        }

        ConfigDB.closedConnection();

        return isDeleted;
    }
}
