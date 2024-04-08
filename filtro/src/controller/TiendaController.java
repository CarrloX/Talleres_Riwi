package controller;

import entity.Tienda;
import model.TiendaModel;
import utils.Utils;

import javax.swing.*;
import java.util.List;

public class TiendaController {

    public static void create(){
        String nombre = JOptionPane.showInputDialog("ingresa el nombre de la tienda");
        String ubicacion = JOptionPane.showInputDialog("ingresa la ubicacion de la tienda");

        instanceModel().create(new Tienda(nombre,ubicacion));
    }

    public static TiendaModel instanceModel(){
        return new TiendaModel();
    }

    public static void read(){
        String list=read(instanceModel().read());
        JOptionPane.showMessageDialog(null,list);
    }

    public static String read(List<Object> list){
        String listString = "LISTA DE TIENDAS: \n";

        for (Object temp: list){
            Tienda objTienda = (Tienda)temp;
            listString +=objTienda.toString() + "\n";
        }
        return listString;
    }

    public static void update(){
        Object[] opciones = Utils.listToArray(instanceModel().read());

        Tienda objSeleccion = (Tienda) JOptionPane.showInputDialog(
                null,
                "selecciona una tienda para actualizar: ",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        objSeleccion.setNombre(JOptionPane.showInputDialog(null,"ingresa el nuevo nombre para la tienda:",objSeleccion.getNombre()));
        objSeleccion.setUbicacion(JOptionPane.showInputDialog(null,"ingresa la nueva ubicacion para la tienda:",objSeleccion.getUbicacion()));

        instanceModel().update(objSeleccion);
    }

    public static void delete(){
        Object[] opciones = Utils.listToArray(instanceModel().read());

        Tienda objSeleccion = (Tienda) JOptionPane.showInputDialog(
                null,
                "selecciona una tienda para eliminar: ",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );
        instanceModel().delete(objSeleccion);
    }
}
