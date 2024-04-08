package controller;

import entity.Producto;
import entity.Tienda;
import model.ProductoModel;
import utils.Utils;

import javax.swing.*;
import java.util.List;

public class ProductoController {

    public static void create(){
        String nombre = JOptionPane.showInputDialog("ingresa el nombre del producto");
        String precio = JOptionPane.showInputDialog("ingresa el precio del producto (numeros mas un punto y 2 numeros)");

        Object[] opcionesTienda= Utils.listToArray(TiendaController.instanceModel().read());

        Tienda TiendaSeleccion = (Tienda) JOptionPane.showInputDialog(
                null,
                "selecciona la tienda al que le deseas asignar el producto",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcionesTienda,
                opcionesTienda[0]
        );

        instanceModel().create(new Producto(nombre,precio,TiendaSeleccion.getId_tienda(),TiendaSeleccion));
    }

    public static void read(){
        String list=read(instanceModel().read());
        JOptionPane.showMessageDialog(null,list);
    }

    public static String read(List<Object> list){
        String listString = "LISTA DE REGISTROS: \n";

        for (Object temp: list){
            Producto objProducto = (Producto) temp;
            listString +=objProducto.toString() + "\n";
        }
        return listString;
    }

    public static void update(){
        Object[] opciones = Utils.listToArray(instanceModel().read());

        Producto objSeleccion = (Producto) JOptionPane.showInputDialog(
                null,
                "selecciona un producto para actualizar: ",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        objSeleccion.setNombre(JOptionPane.showInputDialog(null,"ingresa el nuevo destino:",objSeleccion.getNombre()));
        objSeleccion.setPrecio(JOptionPane.showInputDialog(null,"ingresa la nueva fecha:",objSeleccion.getPrecio()));

        instanceModel().update(objSeleccion);
    }

    public static void delete(){
        Object[] opciones = Utils.listToArray(instanceModel().read());

        Producto objSeleccion = (Producto) JOptionPane.showInputDialog(
                null,
                "selecciona un producto para eliminar: ",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );
        instanceModel().delete(objSeleccion);
    }

    public static ProductoModel instanceModel(){
        return new ProductoModel();
    }
}
