import java.util.ArrayList;

public class Estudiante {
    private String nombre;
    private ArrayList<Double> calificaciones;

    public Estudiante(String nombre) {
        this.nombre = nombre;
        this.calificaciones = new ArrayList<>();
    }

    public double calcularPromedio() {
        if (calificaciones.isEmpty()) {
            return 0.0;
        }

        double suma = 0;
        for (double calificacion : calificaciones) {
            suma += calificacion;
        }

        return suma / calificaciones.size();
    }

    public void agregarCalificacion(double calificacion) {
        calificaciones.add(calificacion);
    }

    public ArrayList<Double> getCalificaciones() {
        return calificaciones;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Estudiante{" +
                "nombre=" + nombre +
                ", calificaciones=" + calificaciones +
                '}';
    }
}
