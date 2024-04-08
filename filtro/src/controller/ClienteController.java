package controller;

import entity.Cliente;
import model.ClienteModel;
import utils.Utils;

import javax.swing.*;
import java.util.List;

public class ClienteController {

    public static void create(){
        String nombre = JOptionPane.showInputDialog("ingresa el nombre del cliente");
        String apellido =JOptionPane.showInputDialog("ingresa el apellido del cliente");
        String email = JOptionPane.showInputDialog("ingresa el email del cliente");
        instanceModel().create(new Cliente(nombre,apellido,email));
    }

    public static void read(){
        String list=read(instanceModel().read());
        JOptionPane.showMessageDialog(null,list);
    }

    public static String read(List<Object> list){
        String listString = "LISTA DE CLIENTES: \n";

        for (Object temp: list){
            Cliente objCliente = (Cliente) temp;
            listString +=objCliente.toString() + "\n";
        }
        return listString;
    }

    public static void update(){
        Object[] opciones = Utils.listToArray(instanceModel().read());

        Cliente objSeleccion = (Cliente) JOptionPane.showInputDialog(
                null,
                "selecciona un cliente para actualizar: ",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        objSeleccion.setNombre(JOptionPane.showInputDialog(null,"ingresa el nuevo nombre para el cliente:",objSeleccion.getNombre()));
        objSeleccion.setApellido(JOptionPane.showInputDialog(null,"ingresa el nuevo apellido del cliente:",objSeleccion.getApellido()));
        objSeleccion.setEmail(JOptionPane.showInputDialog(null,"ingresa el nuevo email del cliente",objSeleccion.getEmail()));

        instanceModel().update(objSeleccion);
    }

    public static void delete(){
        Object[] opciones = Utils.listToArray(instanceModel().read());

        Cliente objSeleccion = (Cliente) JOptionPane.showInputDialog(
                null,
                "selecciona un cliente para eliminar: ",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );
        instanceModel().delete(objSeleccion);
    }

    public static ClienteModel instanceModel(){
        return new ClienteModel();
    }
}
