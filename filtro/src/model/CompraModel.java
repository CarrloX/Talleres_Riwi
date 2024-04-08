package model;

import database.CRUD;
import database.ConfigDB;
import entity.Cliente;
import entity.Compra;
import entity.Producto;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompraModel implements CRUD {
    @Override
    public Object create(Object obj) {

        Connection objConnection = ConfigDB.openConnection();

        Compra objCompra = (Compra) obj;

        try {
            String sql = "INSERT INTO compra (id_cliente,id_producto,fecha_compra,cantidad) VALUES (?,?,?,?);";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setInt(1, objCompra.getId_cliente());
            objPrepare.setInt(2, objCompra.getId_procucto());
            objPrepare.setString(3, objCompra.getFecha_compra());
            objPrepare.setInt(4,objCompra.getCantidad());

            objPrepare.execute();

            ResultSet objResult = objPrepare.getGeneratedKeys();

            while (objResult.next()) {
                objCompra.setId_compra(objResult.getInt(1));
            }

            JOptionPane.showMessageDialog(null, "La compra fue realizada correctamente");
        } catch (SQLException e) {
            System.out.println("error" + e.getMessage());
        }
        ConfigDB.closedConnection();
        return objCompra;
    }

    @Override
    public List<Object> read(){

        List<Object> listaCompras= new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = """
                    SELECT * FROM compra
                    INNER JOIN cliente ON cliente.id_cliente = compra.id_cliente
                    INNER JOIN producto ON producto.id_producto = compra.id_producto;""";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()) {
                Compra objCompra = new Compra();
                Cliente objCliente = new Cliente();
                Producto objProducto = new Producto();

                objCompra.setId_compra(objResult.getInt("compra.id_compra"));
                objCompra.setId_cliente(objResult.getInt("cliente.id_cliente"));
                objCompra.setId_procucto(objResult.getInt("producto.id_producto"));
                objCompra.setFecha_compra(objResult.getString("compra.fecha_compra"));
                objCompra.setCantidad(objResult.getInt("compra.cantidad"));

                objCliente.setNombre(objResult.getString("cliente.nombre"));
                objProducto.setNombre(objResult.getString("producto.nombre"));
                objCompra.setObjCliente(objCliente);
                objCompra.setObjProducto(objProducto);

                listaCompras.add(objCompra);
            }
        } catch (SQLException e) {
            System.out.println("error" + e.getMessage());
        }

        ConfigDB.closedConnection();
        return listaCompras;
    }

    @Override
    public boolean update(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Compra objCompra = (Compra) obj;

        boolean isUpdated=false;

        try {
            String sql = "UPDATE compra SET id_cliente = ?, id_producto = ? , fecha_compra = ? , cantidad = ? WHERE id_compra = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1,objCompra.getId_cliente());
            objPrepare.setInt(2, objCompra.getId_procucto());
            objPrepare.setDate(3, Date.valueOf(objCompra.getFecha_compra()));
            objPrepare.setInt(4,objCompra.getCantidad());
            objPrepare.setInt(5,objCompra.getId_compra());

            int totalRowAffected = objPrepare.executeUpdate();

            if (totalRowAffected > 0){
                isUpdated=true;
                JOptionPane.showMessageDialog(null,"la compra fue actualizada correctamente");
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
        Compra objCompra = (Compra) obj;
        boolean isDelete = false;

        try{

            String sql = "DELETE FROM compra WHERE id_compra = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1,objCompra.getId_compra());

            int totalRowAffected = objPrepare.executeUpdate();

            if(totalRowAffected>0){
                isDelete = true;
                JOptionPane.showMessageDialog(null,"Compra eliminada correctamente");
            }
        }catch (SQLException e){
            System.out.printf("error"+e.getMessage());
        }
        ConfigDB.closedConnection();
        return isDelete;
    }
}
