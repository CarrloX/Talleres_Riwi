package model;

import database.CRUD;
import database.ConfigDB;
import entity.Producto;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoModel implements CRUD {
    public Object create(Object obj) {
        System.out.println(obj);

        Connection objConnection = ConfigDB.openConnection();

        Producto objProducto = (Producto) obj;

        try {
            String sql = "INSERT INTO producto (nombre,precio,id_tienda) VALUES (?,?,?);";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1, objProducto.getNombre());
            objPrepare.setDouble(2, Double.parseDouble(objProducto.getPrecio()));
            objPrepare.setInt(3,objProducto.getId_tienda());

            objPrepare.execute();

            ResultSet objResult = objPrepare.getGeneratedKeys();

            while (objResult.next()) {
                objProducto.setId_tienda(objResult.getInt(1));
            }

            JOptionPane.showMessageDialog(null, "El producto fue agregado correctamente");
        } catch (SQLException e) {
            System.out.println("error" + e.getMessage());
        }
        ConfigDB.closedConnection();
        return objProducto;
    }

    @Override
    public List<Object> read(){

        List<Object> listaProductos = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "SELECT * FROM producto;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()) {
                Producto objProducto = new Producto();

                objProducto.setId_producto(objResult.getInt("id_producto"));
                objProducto.setNombre(objResult.getString("nombre"));
                objProducto.setPrecio(objResult.getString("precio"));
                objProducto.setId_tienda(objResult.getInt("id_tienda"));

                listaProductos.add(objProducto);
            }
        } catch (SQLException e) {
            System.out.println("error" + e.getMessage());
        }

        ConfigDB.closedConnection();
        return listaProductos;
    }

    @Override
    public boolean update(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Producto objProducto = (Producto) obj;

        boolean isUpdated=false;

        try {
            String sql = "UPDATE producto SET nombre = ?, precio = ? , id_tienda = ? WHERE id_producto = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setString(1,objProducto.getNombre());
            objPrepare.setString(2, objProducto.getPrecio());
            objPrepare.setInt(3,objProducto.getId_tienda());
            objPrepare.setInt(4,objProducto.getId_producto());

            int totalRowAffected = objPrepare.executeUpdate();

            if (totalRowAffected > 0){
                isUpdated=true;
                JOptionPane.showMessageDialog(null,"el producto fue actualizado correctamente");
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
        Producto objProducto = (Producto) obj;

        boolean isDeleted = false;

        try {
            String sql = "DELETE FROM producto  WHERE id_producto = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1, objProducto.getId_producto());

            int totalAffectedRows = objPrepare.executeUpdate();

            if (totalAffectedRows > 0) {
                isDeleted = true;

                JOptionPane.showMessageDialog(null, "se ha eliminado el producto correctamente");
            }
        } catch (SQLException e) {
            System.out.println("error" + e.getMessage());
        }

        ConfigDB.closedConnection();

        return isDeleted;
    }
}
