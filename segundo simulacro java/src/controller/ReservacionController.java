package controller;

import entity.Pasajero;
import entity.Reservacion;
import entity.Vuelo;
import model.ReservacionModel;
import utils.Utils;

import javax.swing.*;
import java.util.List;

public class ReservacionController {

    public static void create(){

        Object[] opcionesPasajero = Utils.listToArray(PasajeroController.instanceModel().read());

        Pasajero PasajeroSeleccion = (Pasajero) JOptionPane.showInputDialog(
                null,
                "selecciona el pasajero al que le deseas asignarle la reservacion",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcionesPasajero,
                opcionesPasajero[0]
        );

        Object[] opcionesVuelo = Utils.listToArray(VueloController.instanceModel().read());

        Vuelo VueloSeleccion = (Vuelo) JOptionPane.showInputDialog(
                null,
                "selecciona el vuelo al que le deseas asignarle la reservacion",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcionesVuelo,
                opcionesVuelo[0]
        );

        String fecha_reservacion = JOptionPane.showInputDialog("ingresa la fecha de la reservacion (YYYY-MM-DD)");
        String asiento = JOptionPane.showInputDialog("ingresa el asiento que desea reservar");

        instanceModel().create(new Reservacion(PasajeroSeleccion.getId_pasajero(),PasajeroSeleccion,VueloSeleccion.getId_vuelo(),VueloSeleccion,fecha_reservacion,asiento));
    }

    public static void getAll(){
        String listString = getAll(instanceModel().read());
        JOptionPane.showMessageDialog(null,listString);
    }

    public static String getAll(List<Object> list){
        String listString = "LISTA DE REGISTROS: \n";

        for (Object temp: list){
            Reservacion obj = (Reservacion) temp;
            listString +=obj.toString() + "\n";
        }
        return listString;
    }

    public static void update(){
        Object[] opcionesReservacion = Utils.listToArray(instanceModel().read());
        Reservacion reservacionSeleccion = (Reservacion) JOptionPane.showInputDialog(
                null,
                "selecciona la reservacion  para actualizar",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcionesReservacion,
                opcionesReservacion[0]
        );

        Object[] opcionesPasajero = Utils.listToArray(PasajeroController.instanceModel().read());

        reservacionSeleccion.setObjPasajero((Pasajero)JOptionPane.showInputDialog(
                null,
                "selecciona el pasajero que desea cambiar",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcionesPasajero,
                opcionesPasajero[0]
        ));

        reservacionSeleccion.setId_pasajero(reservacionSeleccion.getObjPasajero().getId_pasajero());

        Object[] opcionesVuelo = Utils.listToArray(VueloController.instanceModel().read());

        reservacionSeleccion.setObjVuelo((Vuelo) JOptionPane.showInputDialog(
                null,
                "selecciona el vuelo que desea cambiar",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcionesVuelo,
                opcionesVuelo[0]
        ));

        reservacionSeleccion.setId_vuelo(reservacionSeleccion.getObjVuelo().getId_vuelo());

        reservacionSeleccion.setFecha_reservacion(JOptionPane.showInputDialog(null,"ingresa la nueva fecha de reservacion (YYYY-MM-DD)",reservacionSeleccion.getFecha_reservacion()));
        reservacionSeleccion.setAsiento(JOptionPane.showInputDialog(null,"ingresa el nuevo asiento que desea reservar",reservacionSeleccion.getAsiento()));

        instanceModel().update(reservacionSeleccion);
    }

    public static void delete(){
        Object[] opciones = Utils.listToArray(instanceModel().read());

        Reservacion objSeleccion = (Reservacion) JOptionPane.showInputDialog(
                null,
                "selecciona una reservacion eliminar: ",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );
        instanceModel().delete(objSeleccion);
    }

    public static ReservacionModel instanceModel(){
        return new ReservacionModel();
    }
}
