package ejercicio_04;

public class Main {
    public static void main(String[] args){
        //test 1 calcular el area de un circulo
        circulo objCirculo = new circulo(10);
        System.out.println("el area del circulo es: " + objCirculo.calcularArea());

        //test 2 calcular el area de un cuadrado
        cuadrado objCuadrado = new cuadrado(5);
        System.out.println("El área del cuadrado es: " + objCuadrado.calcularArea());

        //test 3 calcular el area de un rectangulo
        rectangulo objRectangulo = new rectangulo(3, 7); // Alto: 3, Ancho: 7
        System.out.println("El área del rectángulo es: " + objRectangulo.calcularArea());
    }

}
