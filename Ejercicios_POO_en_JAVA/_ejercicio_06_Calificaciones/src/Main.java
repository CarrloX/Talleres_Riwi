import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Estudiante estudiante = new Estudiante("Juan");

        int opcion;
        do {
            String opcionString = JOptionPane.showInputDialog(
                    "MENU\n\n" +
                            "1.calcular promedio de calificaciones\n" +
                            "2.añadir nueva calificación\n" +
                            "3.visualizar lista de calificaciones\n" +
                            "4.salir\n\n" +
                            "selecciona una opción:"
            );

            opcion = Integer.parseInt(opcionString);

            switch (opcion) {
                case 1:
                    double promedio = estudiante.calcularPromedio();
                    JOptionPane.showMessageDialog(null, "el promedio de las calificaciones es: " + promedio);
                    break;
                case 2:
                    String nuevaCalificacionString = JOptionPane.showInputDialog("ingrese la nueva calificación:");
                    double nuevaCalificacion = Double.parseDouble(nuevaCalificacionString);
                    estudiante.agregarCalificacion(nuevaCalificacion);
                    JOptionPane.showMessageDialog(null, "calificación añadida correctamente.");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "lista de calificaciones: " + estudiante.getCalificaciones());
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "saliendo del programa...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        } while (opcion != 4);
    }
}
