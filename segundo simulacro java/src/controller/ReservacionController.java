package controller;

import entity.Pasajero;
import entity.Reservacion;
import entity.Vuelo;
import model.ReservacionModel;
import model.VueloModel;
import utils.Utils;

import javax.swing.*;

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

    public static ReservacionModel instanceModel(){
        return new ReservacionModel();
    }
}
