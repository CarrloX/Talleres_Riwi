import controller.AutorController;
import entity.Autor;

import javax.swing.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AutorController objAutorController = new AutorController();
        String option= "";
        do {
            option= JOptionPane.showInputDialog("""
                    MENU
                    1.Crar Autor
                    2.leer Autores
                    3.Actualizar Autores
                    4.Eliminar Autores
                    5.Salir
                    escoje una opcion:
                    """);
            switch (option){
                case "1"://insert autor
                    String nombreAutor = JOptionPane.showInputDialog("ingresa el nombre del autor:");
                    String nacionalidadAutor = JOptionPane.showInputDialog("ingresa la nacionalidad del autor:");
                    objAutorController.insertAutor(nombreAutor, nacionalidadAutor);
                    break;


                case "2": // Leer autores
                    List<Autor> autores = objAutorController.findAllAutores();
                    StringBuilder message = new StringBuilder("lista de Autores:\n");
                    for (Autor autor : autores) {
                        message.append("ID: ").append(autor.getIdAutor()).append(", Nombre: ").append(autor.getNombre()).append(", Nacionalidad: ").append(autor.getNacionalidad()).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, message.toString());
                    break;


                case "3": // Update autor
                    int idAutorToUpdate = Integer.parseInt(JOptionPane.showInputDialog("ingresa el ID del autor para actualizar:"));
                    objAutorController.updateAutor(idAutorToUpdate);
                    break;


                case "4"://delete coder
                    int idAutorToDelete = Integer.parseInt(JOptionPane.showInputDialog("ingresa el ID del autor para eliminar:"));
                    objAutorController.deleteAutor(idAutorToDelete);
                    break;
            }
        }while(!option.equals("5"));
    }
}