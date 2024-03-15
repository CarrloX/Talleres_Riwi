import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

        inventario inventario = new inventario();

        // Mostrar menú de opciones
        while (true) {
            String opcion = JOptionPane.showInputDialog(
                    "selecciona una opcion:\n" +
                            "1.añadir producto\n" +
                            "2.eliminar producto\n" +
                            "3.listar productos\n" +
                            "4.salir"
            );

            if (opcion == null || opcion.equals("4")) {
                break;
            }

            switch (opcion) {
                case "1":
                    int id = Integer.parseInt(JOptionPane.showInputDialog("ponle un ID al producto:"));
                    String nombre = JOptionPane.showInputDialog("ponle nombre al producto:");
                    double precio = Double.parseDouble(JOptionPane.showInputDialog("ponle precio al producto:"));
                    producto nuevoProducto = new producto(id, nombre, precio);
                    inventario.agregarProducto(nuevoProducto);
                    JOptionPane.showMessageDialog(null, "el producto se ha agregado");
                    break;
                case "2":
                    int idEliminar = Integer.parseInt(JOptionPane.showInputDialog("pon el id del producto para borrar de la lista:"));
                    if (inventario.eliminarProducto(idEliminar)) {
                        JOptionPane.showMessageDialog(null, "el producto ha sido eliminado");
                    } else {
                        JOptionPane.showMessageDialog(null, "no hay ningun producto con ese ID");
                    }
                    break;
                case "3":
                    JOptionPane.showMessageDialog(null, inventario.listarProductos());
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "opcion invalida.");
            }
        }
    }
}
