package controller;

import entity.Avion;
import jdk.jshell.execution.Util;
import model.AvionModel;
import utils.Utils;

import javax.swing.*;
import java.time.temporal.Temporal;
import java.util.List;

public class AvionController {

    public static void create(){
        String modelo = JOptionPane.showInputDialog("ingresa el nombre del modelo del avion");
        int capacidad = Integer.parseInt(JOptionPane.showInputDialog("ingresa la capacidad de pasajeros que podra contener este avion"));

        instanceModel().create(new Avion(modelo,capacidad));
    }

    public static void read(){
        String list=read(instanceModel().read());
        JOptionPane.showMessageDialog(null,list);
    }

    public static String read(List<Object> list){
        String listString = "LISTA DE REGISTROS: \n";

        for (Object temp: list){
            Avion objAvion = (Avion)temp;
            listString +=objAvion.toString() + "\n";
        }
        return listString;
    }

    public static AvionModel instanceModel(){
        return new AvionModel();
    }

    public static void delete(){
        Object[] opciones = Utils.listToArray(instanceModel().read());

        Avion objSeleccion = (Avion) JOptionPane.showInputDialog(
                null,
                "selecciona un avion para eliminar: ",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );
        instanceModel().delete(objSeleccion);
    }

    public static void update(){
        Object[] opciones = Utils.listToArray(instanceModel().read());

        Avion objSeleccion = (Avion) JOptionPane.showInputDialog(
                null,
                "selecciona un avion para actualizar: ",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        objSeleccion.setModelo(JOptionPane.showInputDialog(null,"ingresa el nuevo nombre para el modelo:",objSeleccion.getModelo()));
        objSeleccion.setCapacidad(Integer.parseInt(JOptionPane.showInputDialog(null,"ingresa la nueva capacidad del modelo:",objSeleccion.getCapacidad())));

        instanceModel().update(objSeleccion);
    }
}
