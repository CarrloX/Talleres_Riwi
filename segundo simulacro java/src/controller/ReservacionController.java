package controller;

import entity.Pasajero;
import entity.Reservacion;
import entity.Vuelo;
import model.ReservacionModel;
import model.VueloModel;
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

    public static void read(){
        String list=read(instanceModel().read());
        JOptionPane.showMessageDialog(null,list);
    }

    public static String read(List<Object> list){
        String listString = "LISTA DE REGISTROS: \n";

        for (Object temp: list){
            Reservacion objReservacion = (Reservacion) temp;
            listString +=objReservacion.toString() + "\n";
        }
        return listString;
    }

    public static void update(){
        Object[] opciones = Utils.listToArray(instanceModel().read());

        Reservacion objSeleccion = (Reservacion) JOptionPane.showInputDialog(
                null,
                "selecciona una reservacion para actualizar: ",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        objSeleccion.setId_pasajero(Integer.parseInt(JOptionPane.showInputDialog(null,"ingresa el nuevo pasajero:",objSeleccion.getId_pasajero())));
        objSeleccion.setId_vuelo(Integer.parseInt(JOptionPane.showInputDialog(null,"ingresa el nuevo vuelo:",objSeleccion.getId_vuelo())));
        objSeleccion.setFecha_reservacion(JOptionPane.showInputDialog(null,"ingresa la nueva fecha de reservacion: ",objSeleccion.getFecha_reservacion()));
        objSeleccion.setAsiento(JOptionPane.showInputDialog(null,"ingresa el nuevo asiento",objSeleccion.getAsiento()));

        instanceModel().update(objSeleccion);
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
