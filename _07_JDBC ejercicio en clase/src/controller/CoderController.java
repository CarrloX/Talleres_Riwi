package controller;

import model.CoderModel;
import entity.Coder;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CoderController {

    CoderModel objCoderModel;
    public CoderController(){
        //crear una instancia del modelo
        this.objCoderModel = new CoderModel();
    }

    public void delete(){
        String listCoderString = this.getAll(this.objCoderModel.findAll());

        int confirm = 1;
        int idDelete = Integer.parseInt(JOptionPane.showInputDialog(listCoderString+"Enter the ID of the coder to delete"));
        Coder objCoder =(Coder)this.objCoderModel.findById(idDelete);

        if (objCoder == null){
            JOptionPane.showMessageDialog(null,"Coder not found");
        }else{
            confirm = JOptionPane.showConfirmDialog(null,"Are you sure want to delete the coder: \n"+objCoder.toString());
            //si el usuario escogió que si entonces eliminamos
            if(confirm==0){
                this.objCoderModel.delete(objCoder);
            }
        }
    }

    public void getByName() {
        String nombre = JOptionPane.showInputDialog("Enter the name of the coder to search: ");
        ArrayList<Object> coincidencias = objCoderModel.getByName(new Coder(0, nombre, 0, ""));

        if (coincidencias==null){
            JOptionPane.showMessageDialog(null,"error, we cannot find de coders");
            return;
        }

        if (coincidencias.isEmpty()) {
            JOptionPane.showMessageDialog(null, "not founded coders with that name");
        } else {
            StringBuilder listaCoincidencias = new StringBuilder();
            listaCoincidencias.append("coincidences founded: \n");
            for (Object obj : coincidencias) {
                Coder coder = (Coder) obj;
                listaCoincidencias.append(coder.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(null, listaCoincidencias.toString());
        }
    }

    //método para listar todos los coder
    public void getAll(){

        String list = this.getAll(this.objCoderModel.findAll());
        //mostramos toda la lista
        JOptionPane.showMessageDialog(null,list);
    }

    public String getAll(List<Object> listObject){
        String list = " List Coders\n";
        //iteramos sobre la lista que devuelve el método find All
        for (Object obj : listObject){
            //convertimos o casteamos el objeto tipo objeto a un coder
            Coder objCoder = (Coder) obj;
            //concatenamos la información
            list+=objCoder.toString()+ "\n";
        }
        return list;
    }

    public void create(){
        Coder objCoder = new Coder();

        String name = JOptionPane.showInputDialog("Insert name: ");
        int age = Integer.parseInt(JOptionPane.showInputDialog("Insert age: "));
        String clan = JOptionPane.showInputDialog("Insert clan: ");

        objCoder.setName(name);
        objCoder.setAge(age);
        objCoder.setClan(clan);

        objCoder=(Coder) this.objCoderModel.insert(objCoder);

        JOptionPane.showMessageDialog(null,objCoder.toString());
    }

    public void update(){
        //listamos
        String listCoders = this.getAll(this.objCoderModel.findAll());

        //pedimos el ID
        int idUpdate = Integer.parseInt(JOptionPane.showInputDialog(listCoders+"\nEnter the ID of the coder to edit"));

        //verificamos el ID
        Coder objCoder=(Coder) this.objCoderModel.findById(idUpdate);

        if (objCoder == null){
            JOptionPane.showMessageDialog(null,"Coder not found");
        }else{
            String name = JOptionPane.showInputDialog(null,"Enter new name",objCoder.getName());
            String clan = JOptionPane.showInputDialog(null,"Enter new clan",objCoder.getClan());
            int age = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter new Age",String.valueOf(objCoder.getAge())));

            objCoder.setAge(age);
            objCoder.setName(name);
            objCoder.setClan(clan);

            this.objCoderModel.update(objCoder);
        }
    }
}
