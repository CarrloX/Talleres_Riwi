import java.util.Objects;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //instancias
        Scanner objScan=new Scanner(System.in);
        GestionCurso objGestion = new GestionCurso();
        int option=0;

        do{
            System.out.println("""
                    MENU DE OPCIONES
                    1.administrar curso
                    2.administrar estudiantes
                    3.salir
                    """);
            option = objScan.nextInt();

            switch (option){
                case 1:
                    int option2 =0;
                    do {
                        System.out.println("""
                            MENU DE CURSOS
                            1. crear un curso
                            2.buscar curso por codigo
                            3.listar cursos
                            4.salir
                            """);
                        option2 = objScan.nextInt();
                        switch (option2){
                            case 1:
                                objGestion.guardarCurso(objScan);
                                break;

                            case 2:
                                System.out.println("ingresa el codigo del curso");
                                String codigo = objScan.next();
                                System.out.println(objGestion.buscarPorCodigo(codigo).toString());
                                break;
                            case 3:
                                objGestion.listarCursos();
                                break;

                        }
                    }while (option2 !=4);
                    break;
                case 2:
                    int option3 =0;
                    do {
                        System.out.println("""
                                MENU gestion de estudiantes
                                1.agregar estudiante
                                2.eliminar estudiante
                                3.listar estudiantes
                                4.salir
                                """);
                        option3=objScan.nextInt();

                        switch (option3){
                            case 1:
                                objGestion.listarCursos();

                                System.out.println("ingrese el codigo del curso donde desea inscribir al estudiante");
                                String codigo= objScan.next();
                                Curso curso = objGestion.buscarPorCodigo(codigo);

                                if (curso == null){
                                    System.out.println("curso no encotrado");
                                }else{
                                    curso.guardarEstudiante(objScan);
                                }
                                break;

                            case 2: //caso para eliminar un estudiante
                                //1.listar todos los cursos
                                objGestion.listarCursos();
                                //2.preguntar al usuario de cual es el curso del estudiante a eliminar
                                System.out.println("ingrese el codigo del curso de estudiante a eliminar");
                                codigo= objScan.next();
                                //3.llamar al metodo que elimina
                                Curso objcurso = objGestion.buscarPorCodigo(codigo);
                                if (objcurso == null){
                                    System.out.println("codigo no valido");
                                }else{
                                    //eliminar
                                    objcurso.eliminarEstudiante(objScan);
                                }
                                break;

                            case 3:
                                objGestion.listarCursos();

                                System.out.println("ingrese el codigo del curso para listar los estudiantes");
                                String codigoCurso= objScan.next();
                                curso = objGestion.buscarPorCodigo(codigoCurso);

                                if (curso != null){
                                    curso.listarEstudiantes();
                                }else{
                                    System.out.println("el curso no se ha encontrado");;
                                }
                                break;
                        }
                    }while (option3 !=4);
                    break;
            }
        }while(option !=3);
    }
}