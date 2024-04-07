package model;

import database.CRUD;
import database.ConfigDB;
import entity.Pasajero;
import entity.Reservacion;
import entity.Vuelo;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.sql.Date.valueOf;

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
            objPrepare.setString(3, objReservacion.getFecha_reservacion());
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
    public List<Object> read(){

        List<Object> listaReservaciones = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "SELECT * FROM reservacion\n" +
                    "INNER JOIN pasajero ON pasajero.id_pasajero = reservacion.id_pasajero\n"+
                    "INNER JOIN vuelo ON vuelo.id_vuelo = reservacion.id_vuelo;";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()) {
                Reservacion objReservacion = new Reservacion();
                Pasajero objPasajero = new Pasajero();
                Vuelo objVuelo = new Vuelo();

                objReservacion.setId_reservacion(objResult.getInt("reservacion.id_reservacion"));
                objReservacion.setId_pasajero(objResult.getInt("reservacion.id_pasajero"));
                objReservacion.setId_vuelo(objResult.getInt("reservacion.id_vuelo"));
                objReservacion.setFecha_reservacion(objResult.getString("reservacion.fecha_reservacion"));
                objReservacion.setAsiento(objResult.getString("reservacion.asiento"));

                objPasajero.setNombre(objResult.getString("pasajero.nombre"));
                objVuelo.setDestino(objResult.getString("vuelo.destino"));
                objReservacion.setObjPasajero(objPasajero);
                objReservacion.setObjVuelo(objVuelo);

                listaReservaciones.add(objReservacion);
            }
        } catch (SQLException e) {
            System.out.println("error" + e.getMessage());
        }

        ConfigDB.closedConnection();
        return listaReservaciones;
    }

    @Override
    public boolean update(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Reservacion objReservacion = (Reservacion) obj;

        boolean isUpdated=false;

        try {
            String sql = "UPDATE reservacion SET id_pasajero = ?, id_vuelo = ? , fecha_reservacion = ? , asiento = ? WHERE id_reservacion = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1,objReservacion.getId_pasajero());
            objPrepare.setInt(2, objReservacion.getId_vuelo());
            objPrepare.setDate(3,Date.valueOf(objReservacion.getFecha_reservacion()));
            objPrepare.setString(4,objReservacion.getAsiento());
            objPrepare.setInt(5,objReservacion.getId_reservacion());

            int totalRowAffected = objPrepare.executeUpdate();

            if (totalRowAffected > 0){
                isUpdated=true;
                JOptionPane.showMessageDialog(null,"la reservacion fue actualizado correctamente");
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
        Reservacion objReservacion = (Reservacion) obj;
        boolean isDelete = false;

        try{

            String sql = "DELETE FROM reservacion WHERE id_reservacion = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1,objReservacion.getId_reservacion());

            int totalRowAffected = objPrepare.executeUpdate();

            if(totalRowAffected>0){
                isDelete = true;
                JOptionPane.showMessageDialog(null,"Reservacion eliminada correctamente");
            }
        }catch (SQLException e){
            System.out.printf("error"+e.getMessage());
        }
        ConfigDB.closedConnection();
        return isDelete;
    }
}
