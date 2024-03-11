public class Empleado {
    private String nombre;
    private String cargo;
    private Double salario;
    private Integer id;

    public Empleado() {
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public java.lang.Double getSalario() {
        return salario;
    }

    public void setSalario(java.lang.Double salario) {
        this.salario = salario;
    }

    public java.lang.Integer getId() {
        return id;
    }

    public void setId(java.lang.Integer id) {
        this.id = id;
    }


    //metodo para aumentar el slario dependiendo de un %
    public void aumentarSalario(double porcentaje) {
        this.salario += (this.salario * porcentaje) / 100;
    }

    @java.lang.Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", cargo='" + cargo + '\'' +
                ", salario=" + salario +
                ", id=" + id +
                '}';
    }
}

