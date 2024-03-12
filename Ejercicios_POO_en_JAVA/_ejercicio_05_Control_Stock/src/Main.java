import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        // Creamos un array de productos
        Producto[] productos = new Producto[10];
        int cantidadProductos = 0;

        // Creamos el menú interactivo
        String menu = "selecciona una opcion:\n"
                + "1.agregar producto\n"
                + "2.agregar stock\n"
                + "3.quitar stock\n"
                + "4.listar stock\n"
                + "5.salir";

        while (true) {
            String opcionStr = JOptionPane.showInputDialog(null, menu, "control de stock", JOptionPane.PLAIN_MESSAGE);

            if (opcionStr == null || opcionStr.equals("5")) {
                break;
            }

            int opcion;
            try {
                opcion = Integer.parseInt(opcionStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "opcion invalida", "error", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            switch (opcion) {
                case 1:
                    if (cantidadProductos < productos.length) {
                        String nombreProducto = JOptionPane.showInputDialog("ponle un nombre al nuevo producto:");
                        productos[cantidadProductos] = new Producto(cantidadProductos + 1, nombreProducto, 0);
                        cantidadProductos++;
                        JOptionPane.showMessageDialog(null, "producto agregado", "informacion", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "ya no caben mas productos", "error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 2:
                    agregarStock(productos);
                    break;
                case 3:
                    quitarStock(productos);
                    break;
                case 4:
                    listarStock(productos);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "opcion invalida", "error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void agregarStock(Producto... productos) {
        int productoSeleccionado = seleccionarProducto(productos);
        if (productoSeleccionado != -1) {
            String cantidadStr = JOptionPane.showInputDialog("pon la cantidad de stock para" + productos[productoSeleccionado].getDescripcion() + ":");
            try {
                int cantidad = Integer.parseInt(cantidadStr);
                productos[productoSeleccionado].agregarStock(cantidad);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "opcion invalida", "error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void quitarStock(Producto... productos) {
        int productoSeleccionado = seleccionarProducto(productos);
        if (productoSeleccionado != -1) {
            String cantidadStr = JOptionPane.showInputDialog("cuanto stock quieres quitar de " + productos[productoSeleccionado].getDescripcion() + "?:");
            try {
                int cantidad = Integer.parseInt(cantidadStr);
                productos[productoSeleccionado].quitarStock(cantidad);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "opcion invalida", "error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void listarStock(Producto... productos) {
        StringBuilder mensaje = new StringBuilder("stock actual:\n");
        for (Producto producto : productos) {
            if (producto != null) {
                mensaje.append(producto.getDescripcion()).append(": ").append(producto.getCantidadEnStock()).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, mensaje.toString(), "stock", JOptionPane.INFORMATION_MESSAGE);
    }

    public static int seleccionarProducto(Producto... productos) {
        String[] nombresProductos = new String[productos.length];
        for (int i = 0; i < productos.length; i++) {
            if (productos[i] != null) {
                nombresProductos[i] = productos[i].getDescripcion();
            }
        }
        String productoSeleccionado = (String) JOptionPane.showInputDialog(null, "selecciona un producto:", "selecciona el producto", JOptionPane.PLAIN_MESSAGE, null, nombresProductos, nombresProductos[0]);
        if (productoSeleccionado != null) {
            for (int i = 0; i < nombresProductos.length; i++) {
                if (nombresProductos[i].equals(productoSeleccionado)) {
                    return i;
                }
            }
        }
        return -1;
    }
}
