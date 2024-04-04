package controller;

import utils.Utils;

import javax.swing.*;

public class VueloController {

    public static void create(){
        String destino = JOptionPane.showInputDialog("ingresa el destino del vuelo");
        String fecha_salidad = JOptionPane.showInputDialog("ingresa la fecha en que sale el vuelo");
        String hora_salida = JOptionPane.showInputDialog("ingresa la hora del vuelo");
        String id_avion = JOptionPane.showInputDialog("ingresa el id del avion al cual deseas asignarle el vuelo");

        /*List<Object> opcionesAvion = Utils.listToArray(AvionController);*/
    }
}
