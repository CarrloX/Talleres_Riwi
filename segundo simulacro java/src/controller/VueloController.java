package controller;

import entity.Avion;
import entity.Vuelo;
import model.VueloModel;
import utils.Utils;

import javax.swing.*;
import java.util.List;

public class VueloController {

    public static void create(){
        String destino = JOptionPane.showInputDialog("ingresa el destino del vuelo");
        String fecha_salidad = JOptionPane.showInputDialog("ingresa la fecha en que sale el vuelo (YYYY-MM-DD)");
        String hora_salida = JOptionPane.showInputDialog("ingresa la hora del vuelo (00:00:00)");

        Object[] opcionesAvion = Utils.listToArray(AvionController.instanceModel().read());

        Avion AvionSeleccion = (Avion)JOptionPane.showInputDialog(
                null,
                "selecciona el avion al que le deseas asignar el vuelo",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcionesAvion,
                opcionesAvion[0]
        );

        instanceModel().create(new Vuelo(destino,fecha_salidad,hora_salida,AvionSeleccion.getId_avion(),AvionSeleccion));
    }

    public static void read(){
        String list=read(instanceModel().read());
        JOptionPane.showMessageDialog(null,list);
    }

    public static String read(List<Object> list){
        String listString = "LISTA DE REGISTROS: \n";

        for (Object temp: list){
            Vuelo objVuelo = (Vuelo) temp;
            listString +=objVuelo.toString() + "\n";
        }
        return listString;
    }

    public static void update(){
        Object[] opciones = Utils.listToArray(instanceModel().read());

        Vuelo objSeleccion = (Vuelo) JOptionPane.showInputDialog(
                null,
                "selecciona un vuelo para actualizar: ",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        objSeleccion.setDestino(JOptionPane.showInputDialog(null,"ingresa el nuevo destino:",objSeleccion.getDestino()));
        objSeleccion.setFecha_salida(JOptionPane.showInputDialog(null,"ingresa la nueva fecha:",objSeleccion.getFecha_salida()));
        objSeleccion.setHora_salida(JOptionPane.showInputDialog(null,"ingresa la nueva hora: ",objSeleccion.getHora_salida()));

        instanceModel().update(objSeleccion);
    }

    public static void delete(){
        Object[] opciones = Utils.listToArray(instanceModel().read());

        Vuelo objSeleccion = (Vuelo) JOptionPane.showInputDialog(
                null,
                "selecciona un vuelo para eliminar: ",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );
        instanceModel().delete(objSeleccion);
    }

    public static VueloModel instanceModel(){
        return new VueloModel();
    }
}
