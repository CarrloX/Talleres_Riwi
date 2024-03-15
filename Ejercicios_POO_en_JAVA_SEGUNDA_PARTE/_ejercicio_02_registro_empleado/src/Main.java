//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        GestionEmpleados gestionEmpleados = new GestionEmpleados();

        Empleado empleado1 = new EmpleadoPermanente("Armando Casas",78,1,2500,100);
        Empleado empleado2 = new EmpleadoTemporal("Aquiles Brinco",17,2,800000,"31/02/3033");

        gestionEmpleados.agregarEmpleado(empleado1);
        gestionEmpleados.agregarEmpleado(empleado2);

        gestionEmpleados.mostrarEmpleado();

        gestionEmpleados.eliminarEmpleado(1);

        System.out.println("\n Despues de haberse eliminado");
        gestionEmpleados.mostrarEmpleado();

    }
}