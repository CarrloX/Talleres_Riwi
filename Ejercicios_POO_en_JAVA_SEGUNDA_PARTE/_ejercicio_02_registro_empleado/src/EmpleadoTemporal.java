public class EmpleadoTemporal extends Empleado {
    private String FechaFinContrato;

    public EmpleadoTemporal(String nombre, int edad, int idEmpleado, double salario, String fechaFinContrato) {
        super(nombre, edad, idEmpleado, salario);
        FechaFinContrato = fechaFinContrato;
    }

    public String getFechaFinContrato() {
        return FechaFinContrato;
    }

    public void setFechaFinContrato(String fechaFinContrato) {
        FechaFinContrato = fechaFinContrato;
    }
}

