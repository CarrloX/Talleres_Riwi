package model;

import database.CRUD;
import database.ConfigDB;
import entity.Cliente;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteModel implements CRUD{

    public Object create(Object obj) {

        Connection objConnection = ConfigDB.openConnection();

        Cliente objCliente = (Cliente) obj;

        try {
            String sql = "INSERT INTO cliente (nombre,apellido,email) VALUES (?,?,?);";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1, objCliente.getNombre());
            objPrepare.setString(2, objCliente.getApellido());
            objPrepare.setString(3, objCliente.getEmail());

            objPrepare.execute();

            ResultSet objResult = objPrepare.getGeneratedKeys();

            while (objResult.next()) {
                objCliente.setId_cliente(objResult.getInt(1));
            }

            JOptionPane.showMessageDialog(null, "El cliente fue agregado correctamente");
        } catch (SQLException e) {
            System.out.println("error" + e.getMessage());
        }
        ConfigDB.closedConnection();
        return objCliente;
    }

    public List<Object> read() {

        List<Object> listaCliente = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "SELECT * FROM cliente;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()) {
                Cliente objCliente = new Cliente();

                objCliente.setId_cliente(objResult.getInt("id_cliente"));
                objCliente.setNombre(objResult.getString("nombre"));
                objCliente.setApellido(objResult.getString("apellido"));
                objCliente.setEmail(objResult.getString("email"));

                listaCliente.add(objCliente);
            }
        } catch (SQLException e) {
            System.out.println("error" + e.getMessage());
        }

        ConfigDB.closedConnection();
        return listaCliente;
    }

    @Override
    public boolean update(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Cliente objCliente = (Cliente) obj;

        boolean isUpdated=false;

        try {
            String sql = "UPDATE cliente SET nombre = ?, apellido = ? , email = ? WHERE id_cliente=?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setString(1,objCliente.getNombre());
            objPrepare.setString(2,objCliente.getApellido());
            objPrepare.setString(3,objCliente.getEmail());
            objPrepare.setInt(4,objCliente.getId_cliente());

            int totalRowAffected = objPrepare.executeUpdate();

            if (totalRowAffected > 0){
                isUpdated=true;
                JOptionPane.showMessageDialog(null,"el cliente fue actualizado correctamente");
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
        Cliente objCliente = (Cliente) obj;

        boolean isDeleted = false;

        try {
            String sql = "DELETE FROM cliente  WHERE id_cliente = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1, objCliente.getId_cliente());

            int totalAffectedRows = objPrepare.executeUpdate();

            if (totalAffectedRows > 0) {
                isDeleted = true;

                JOptionPane.showMessageDialog(null, "se ha eliminado el cliente correctamente");
            }
        } catch (SQLException e) {
            System.out.println("error" + e.getMessage());
        }

        ConfigDB.closedConnection();

        return isDeleted;
    }
}
