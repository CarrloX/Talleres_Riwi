package model;

import database.CRUD;
import database.ConfigDB;
import entity.Vuelo;

import javax.swing.*;
import java.sql.*;
import java.util.List;

public class VueloModel implements CRUD {
    @Override
    public Object create(Object obj) {

        Connection objConnection = ConfigDB.openConnection();

        Vuelo objVuelo = (Vuelo) obj;

        try {
            String sql = "INSERT INTO vuelo (destino,fecha_salida,hora_salida,id_avion) VALUES (?,?,?,?);";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1, objVuelo.getDestino());
            objPrepare.setDate(2, Date.valueOf(objVuelo.getFecha_salida()));
            objPrepare.setTime(3,Time.valueOf(objVuelo.getHora_salida()));
            objPrepare.setInt(4,objVuelo.getId_avion());

            objPrepare.execute();

            ResultSet objResult = objPrepare.getGeneratedKeys();

            while (objResult.next()) {
                objVuelo.setId_vuelo(objResult.getInt(1));
            }

            JOptionPane.showMessageDialog(null, "El vuelo fue agregado correctamente");
        } catch (SQLException e) {
            System.out.println("error" + e.getMessage());
        }
        ConfigDB.closedConnection();
        return objVuelo;
    }

    @Override
    public List<Object> read() {
        return null;
    }

    @Override
    public boolean update(Object obj) {
        return false;
    }

    @Override
    public boolean delete(Object obj) {
        return false;
    }
}
