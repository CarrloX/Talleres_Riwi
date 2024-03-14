import java.util.ArrayList;
import java.util.Scanner;

public class GestionCurso {
    private ArrayList<Curso> listaCursos;

    public GestionCurso(){
        this.listaCursos = new ArrayList<>();
    }

    public void guardarCurso(Scanner objScan){
        System.out.println("agregar curso");

        System.out.println("ingresa el nombre del curso");
        String nombre= objScan.next();

        System.out.println("ingresa el codigo del curso");
        String codigo=objScan.next();
        //si el metodo buscar no devuelve null quiere decir que ya existe
        if (this.buscarPorCodigo(codigo)!=null){
            System.out.println("el codigo ya esta existe");
        }else{
            //creamos el curso
            Curso objCurso = new Curso(codigo,nombre);
            this.listaCursos.add(objCurso);
        }
    }

    public Curso buscarPorCodigo(String codigoBuscar){
        for (Curso cursoTemp:this.listaCursos){
            if (cursoTemp.getCodigo().equalsIgnoreCase(codigoBuscar)){
                return cursoTemp;
            }
        }
        return null;
    }

    public void listarCursos(){
        if (this.listaCursos.isEmpty()){
            System.out.println("no hay cursos registrados");
        }else{
            System.out.println("lista de cursos");
            for(Curso temp:this.listaCursos){
                System.out.println(temp.toString());
            }
        }
    }

    public ArrayList<Curso> getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(ArrayList<Curso> listaCursos) {
        this.listaCursos = listaCursos;
    }
}
