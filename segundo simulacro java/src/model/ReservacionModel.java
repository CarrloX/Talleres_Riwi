package model;

import database.CRUD;
import database.ConfigDB;
import entity.Reservacion;
import entity.Vuelo;

import javax.swing.*;
import java.sql.*;
import java.util.List;

public class ReservacionModel implements CRUD {
    @Override
    public Object create(Object obj) {

        Connection objConnection = ConfigDB.openConnection();

        Reservacion objReservacion = (Reservacion) obj;

        try {
            String sql = "INSERT INTO reservacion (id_pasajero,id_vuelo,fecha_reservacion,asiento) VALUES (?,?,?,?);";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setInt(1, objReservacion.getId_pasajero());
            objPrepare.setInt(2, objReservacion.getId_vuelo());
            objPrepare.setDate(3, Date.valueOf(objReservacion.getFecha_reservacion()));
            objPrepare.setString(4,objReservacion.getAsiento());

            objPrepare.execute();

            ResultSet objResult = objPrepare.getGeneratedKeys();

            while (objResult.next()) {
                objReservacion.setId_reservacion(objResult.getInt(1));
            }

            JOptionPane.showMessageDialog(null, "La reservacion fue agregada correctamente");
        } catch (SQLException e) {
            System.out.println("error" + e.getMessage());
        }
        ConfigDB.closedConnection();
        return objReservacion;
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
