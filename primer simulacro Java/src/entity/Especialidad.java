package entity;

public class Especialidad {
    private int idEspecialidad;

    private String nombre;

    private String descricion;

    public Especialidad(int idEspecialidad, String nombre, String descricion) {
        this.idEspecialidad = idEspecialidad;
        this.nombre = nombre;
        this.descricion = descricion;
    }

    public Especialidad() {
    }

    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescricion() {
        return descricion;
    }

    public void setDescricion(String descricion) {
        this.descricion = descricion;
    }

    @Override
    public String toString() {
        return "Especialidad{" +
                "idEspecialidad=" + idEspecialidad +
                ", nombre='" + nombre + '\'' +
                ", descricion='" + descricion + '\'' +
                '}';
    }
}
