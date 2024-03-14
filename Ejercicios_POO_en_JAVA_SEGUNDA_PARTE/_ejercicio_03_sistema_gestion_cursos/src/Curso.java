import java.util.ArrayList;
import java.util.Scanner;

public class Curso {
    private String codigo;
    private String nombre;
    private ArrayList<Estudiante> listaEstudiantes;

    private static int idEstudiante=1;

    public Curso(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.listaEstudiantes = new ArrayList<>();
    }
    public void guardarEstudiante(Scanner objScan){
        System.out.println("Agregar nuevo estudainte\n");
        System.out.println("Ingresa el nombre del estudiante:");
        String nombre= objScan.next();

        System.out.println("Ingresa el email del estudiante");
        String email= objScan.next();

        Estudiante objEstudiante = new Estudiante(idEstudiante,nombre,email);
        idEstudiante++;

        if (listaEstudiantes.add(objEstudiante)){
            System.out.println("estudiante agregado correctamente");
        }else {
            System.out.println("no se puedo agregar el estudiante");
        }
    }

    public void listarEstudiantes(){
        //validar si la lista esta vacia
        if(this.listaEstudiantes.isEmpty()){
            System.out.println("el curso".concat(this.nombre).concat("no tiene estudiantes"));
        }else{
            System.out.println("\nlista de estudiantes - "+this.nombre);
            for (Estudiante estudianteTemp: this.listaEstudiantes){
                System.out.println(estudianteTemp.toString());
            }
        }
    }

    public void eliminarEstudiante(Scanner objScan) {
        //listar
        this.listarEstudiantes();
        //pedir el id
        System.out.println("ingresa el id del usuario a eliminar");
        int idEliminar = objScan.nextInt();
        //eliminar
        if (this.listaEstudiantes.removeIf(estudiante -> estudiante.getId() == idEliminar)){
            System.out.println("estudinate eliminado correctamente");
        }else{
        System.out.println("el estudiante no se removio");
        }
    }


    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(ArrayList<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
