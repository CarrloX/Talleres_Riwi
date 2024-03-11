import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Empleado empleado1 = null;
        Empleado empleado2 = null;

        while (true) {
            String opcionPrincipal = JOptionPane.showInputDialog(
                    "1.agregar empleado\n" +
                            "2.modificar empleado\n" +
                            "3.aumentar salario de un empleado\n" +
                            "4.ver información de empleados\n" +
                            "5.Salir\n" +
                            "ingresa un numero:");

            if (opcionPrincipal == null) {
                break;
            }

            switch (opcionPrincipal) {
                case "1":
                    if (empleado1 == null) {
                        empleado1 = crearEmpleado();
                    } else if (empleado2 == null) {
                        empleado2 = crearEmpleado();
                    } else {
                        JOptionPane.showMessageDialog(null, "ya no caben mas empleados :(");
                    }
                    break;
                case "2":
                    modificarEmpleado(empleado1, empleado2);
                    break;
                case "3":
                    aumentarSalario(empleado1, empleado2);
                    break;
                case "4":
                    mostrarInformacionEmpleados(empleado1, empleado2);
                    break;
                case "5":
                    JOptionPane.showMessageDialog(null, "me voy...");
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "opcion invalida");
                    break;
            }
        }
    }

    public static Empleado crearEmpleado() {
        Empleado empleado = new Empleado();
        empleado.setNombre(JOptionPane.showInputDialog("ponle nombre al empleado:"));
        empleado.setCargo(JOptionPane.showInputDialog("ponle cargo al empleado:"));
        String salarioStr = JOptionPane.showInputDialog("ponle nombre al empleado:");
        empleado.setSalario(Double.parseDouble(salarioStr));
        String idStr = JOptionPane.showInputDialog("ponle id al empleado:");
        empleado.setId(Integer.parseInt(idStr));
        return empleado;
    }

    public static void modificarEmpleado(Empleado empleado1, Empleado empleado2) {
        if (empleado1 == null && empleado2 == null) {
            JOptionPane.showMessageDialog(null, "aun no hay empleados");
            return;
        }

        String opcionModificar = JOptionPane.showInputDialog(
                "que empleado quiere modificar?:\n" +
                        "1.empleado 1\n" +
                        "2.empleado 2");

        switch (opcionModificar) {
            case "1":
                if (empleado1 != null) {
                    modificarAtributosEmpleado(empleado1);
                } else {
                    JOptionPane.showMessageDialog(null, "el empleado 1 no esta");
                }
                break;
            case "2":
                if (empleado2 != null) {
                    modificarAtributosEmpleado(empleado2);
                } else {
                    JOptionPane.showMessageDialog(null, "el empleado 1 no esta");
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "opcion invalida");
                break;
        }
    }

    public static void modificarAtributosEmpleado(Empleado empleado) {
        String nuevoCargo = JOptionPane.showInputDialog("pon el nuevo cargo del empleado:");
        empleado.setCargo(nuevoCargo);
        JOptionPane.showMessageDialog(null, "cargo aplicado correctamente");
    }

    public static void aumentarSalario(Empleado empleado1, Empleado empleado2) {
        if (empleado1 == null && empleado2 == null) {
            JOptionPane.showMessageDialog(null, "no hay empleados para aumentarles el salario");
            return;
        }

        String opcionAumento = JOptionPane.showInputDialog(
                "a cual empleado quieres subirle el salario?:\n" +
                        "1.empleado 1\n" +
                        "2.empleado 2");

        switch (opcionAumento) {
            case "1":
                if (empleado1 != null) {
                    aumentarSalarioEmpleado(empleado1);
                } else {
                    JOptionPane.showMessageDialog(null, "el empleado 1 no existe");
                }
                break;
            case "2":
                if (empleado2 != null) {
                    aumentarSalarioEmpleado(empleado2);
                } else {
                    JOptionPane.showMessageDialog(null, "el empleado 1 no existe");
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "opcion invalida");
                break;
        }
    }

    public static void aumentarSalarioEmpleado(Empleado empleado) {
        String porcentajeStr = JOptionPane.showInputDialog("ingresa el % de aumento:");
        if (porcentajeStr != null) {
            try {
                double porcentaje = Double.parseDouble(porcentajeStr);
                empleado.aumentarSalario(porcentaje);
                JOptionPane.showMessageDialog(null, "salario aumentado exitosamente");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "opcion invalida");
            }
        }
    }

    public static void mostrarInformacionEmpleados(Empleado empleado1, Empleado empleado2) {
        StringBuilder infoEmpleados = new StringBuilder();
        if (empleado1 != null) {
            infoEmpleados.append("info del empleado 1:\n").append(empleado1).append("\n\n");
        } else {
            infoEmpleados.append("empleado 1 vacio:\n\n");
        }
        if (empleado2 != null) {
            infoEmpleados.append("info del empleado 2:\n").append(empleado2);
        } else {
            infoEmpleados.append("empelado 2 vacio");
        }
        JOptionPane.showMessageDialog(null, infoEmpleados.toString());
    }
}
