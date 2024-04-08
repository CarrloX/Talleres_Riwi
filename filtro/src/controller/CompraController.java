package controller;

import entity.Cliente;
import entity.Compra;
import entity.Producto;
import model.CompraModel;
import utils.Utils;

import javax.swing.*;
import java.util.List;

public class CompraController {

    public static void create(){

        Object[] opcionesCliente = Utils.listToArray(ClienteController.instanceModel().read());

        Cliente ClienteSeleccion = (Cliente) JOptionPane.showInputDialog(
                null,
                "selecciona el cliente al que le deseas asignarle la compra",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcionesCliente,
                opcionesCliente[0]
        );

        Object[] opcionesProducto = Utils.listToArray(ProductoController.instanceModel().read());

        Producto ProductoSeleccion = (Producto) JOptionPane.showInputDialog(
                null,
                "selecciona el producto al que le deseas asignarle la compra",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcionesProducto,
                opcionesProducto[0]
        );

        String fecha_compra = JOptionPane.showInputDialog("ingresa la fecha de la compra (YYYY-MM-DD)");
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("ingresa la cantidad que desea comprar"));

        instanceModel().create(new Compra(ClienteSeleccion.getId_cliente(),ClienteSeleccion,ProductoSeleccion.getId_producto(),ProductoSeleccion,fecha_compra,cantidad));
    }

    public static void getAll(){
        String listString = getAll(instanceModel().read());
        JOptionPane.showMessageDialog(null,listString);
    }

    public static String getAll(List<Object> list){
        String listString = "LISTA DE COMPRAS: \n";

        for (Object temp: list){
            Compra obj = (Compra) temp;
            listString +=obj.toString() + "\n";
        }
        return listString;
    }

    public static void update(){
        Object[] opcionesCompra = Utils.listToArray(instanceModel().read());
        Compra compraSeleccion = (Compra) JOptionPane.showInputDialog(
                null,
                "selecciona la compra para actualizar",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcionesCompra,
                opcionesCompra[0]
        );

        Object[] opcionesCliente = Utils.listToArray(ClienteController.instanceModel().read());

        compraSeleccion.setObjCliente((Cliente) JOptionPane.showInputDialog(
                null,
                "selecciona el cliente que desea cambiar",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcionesCliente,
                opcionesCliente[0]
        ));

        compraSeleccion.setId_cliente(compraSeleccion.getObjCliente().getId_cliente());

        Object[] opcionesProducto = Utils.listToArray(ProductoController.instanceModel().read());

        compraSeleccion.setObjProducto((Producto) JOptionPane.showInputDialog(
                null,
                "selecciona el producto que desea cambiar",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcionesProducto,
                opcionesProducto[0]
        ));

        compraSeleccion.setId_procucto(compraSeleccion.getObjProducto().getId_producto());

        compraSeleccion.setFecha_compra(JOptionPane.showInputDialog(null,"ingresa la nueva fecha de compra (YYYY-MM-DD)",compraSeleccion.getFecha_compra()));
        compraSeleccion.setCantidad(Integer.parseInt(JOptionPane.showInputDialog(null,"ingresa la nueva cantidad para comprar",compraSeleccion.getCantidad())));

        instanceModel().update(compraSeleccion);
    }

    public static void delete(){
        Object[] opciones = Utils.listToArray(instanceModel().read());

        Compra objSeleccion = (Compra) JOptionPane.showInputDialog(
                null,
                "selecciona una compra para eliminar: ",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );
        instanceModel().delete(objSeleccion);
    }

    public static CompraModel instanceModel(){
        return new CompraModel();
    }
}
