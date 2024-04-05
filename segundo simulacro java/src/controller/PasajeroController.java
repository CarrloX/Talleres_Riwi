package controller;

import entity.Avion;
import entity.Pasajero;
import model.PasajeroModel;
import utils.Utils;

import javax.swing.*;
import java.util.List;

public class PasajeroController {

    public static void create(){
        String nombre = JOptionPane.showInputDialog("ingresa el nombre del pasajero");
        String apellido =JOptionPane.showInputDialog("ingresa el apellido del pasajero");
        String documentoIdentidad = JOptionPane.showInputDialog("ingresa el documento de identidad del pasajero");
        instanceModel().create(new Pasajero(nombre,apellido,documentoIdentidad));
    }

    public static void read(){
        String list=read(instanceModel().read());
        JOptionPane.showMessageDialog(null,list);
    }

    public static String read(List<Object> list){
        String listString = "LISTA DE REGISTROS: \n";

        for (Object temp: list){
            Pasajero objPasajero = (Pasajero) temp;
            listString +=objPasajero.toString() + "\n";
        }
        return listString;
    }

    public static void update(){
        Object[] opciones = Utils.listToArray(instanceModel().read());

        Pasajero objSeleccion = (Pasajero) JOptionPane.showInputDialog(
                null,
                "selecciona un pasajero para actualizar: ",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        objSeleccion.setNombre(JOptionPane.showInputDialog(null,"ingresa el nuevo nombre para el pasajero:",objSeleccion.getNombre()));
        objSeleccion.setApellido(JOptionPane.showInputDialog(null,"ingresa el nuevo apellido del pasajero:",objSeleccion.getApellido()));
        objSeleccion.setDocumento_identidad(JOptionPane.showInputDialog(null,"ingresa el nuevo documento de identidad del pasajero",objSeleccion.getDocumento_identidad()));

        instanceModel().update(objSeleccion);
    }

    public static void delete(){
        Object[] opciones = Utils.listToArray(instanceModel().read());

        Pasajero objSeleccion = (Pasajero) JOptionPane.showInputDialog(
                null,
                "selecciona un pasajero para eliminar: ",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );
        instanceModel().delete(objSeleccion);
    }

    public static PasajeroModel instanceModel(){
        return new PasajeroModel();
    }
}
