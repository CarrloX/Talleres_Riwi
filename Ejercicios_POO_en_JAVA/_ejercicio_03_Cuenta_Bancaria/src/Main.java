import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria("Juan Pérez", 1000.0);

        while (true) {
            String opcion = JOptionPane.showInputDialog(
                    "menu:\n" +
                            "1.mostrar balance\n" +
                            "2.depositar dinero\n" +
                            "3.retirar dinero\n" +
                            "4.salir\n" +
                            "elije una opcion:");

            if (opcion == null) {
                break;
            }

            switch (opcion) {
                case "1":
                    mostrarBalance(cuenta);
                    break;
                case "2":
                    depositarDinero(cuenta);
                    break;
                case "3":
                    retirarDinero(cuenta);
                    break;
                case "4":
                    JOptionPane.showMessageDialog(null, "me voy...");
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "opcion invalida");
                    break;
            }
        }
    }

    public static void mostrarBalance(CuentaBancaria cuenta) {
        JOptionPane.showMessageDialog(null, "el balance es de: $" + cuenta.getBalance());
    }

    public static void depositarDinero(CuentaBancaria cuenta) {
        String cantidadStr = JOptionPane.showInputDialog("cuanto money vas a depositar?:");
        if (cantidadStr != null) {
            try {
                double cantidad = Double.parseDouble(cantidadStr);
                cuenta.depositar(cantidad);
                JOptionPane.showMessageDialog(null, "deposito realizado correctamente");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "error");
            }
        }
    }

    public static void retirarDinero(CuentaBancaria cuenta) {
        String cantidadStr = JOptionPane.showInputDialog("cuanto dienero vas a retirar?:");
        if (cantidadStr != null) {
            try {
                double cantidad = Double.parseDouble(cantidadStr);
                if (cantidad <= cuenta.getBalance()) {
                    cuenta.retirar(cantidad);
                    JOptionPane.showMessageDialog(null, "retiro realizado correctamente");
                } else {
                    JOptionPane.showMessageDialog(null, "error, te pasaste");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "opcion invalida");
            }
        }
    }
}
