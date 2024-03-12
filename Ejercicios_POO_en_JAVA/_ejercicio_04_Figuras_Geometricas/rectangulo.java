package ejercicio_04;

public class rectangulo extends figura {
    private double alto;
    private double ancho;

    public rectangulo(double alto, double ancho) {
        this.alto=alto;
        this.ancho=ancho;
    }

    @Override
    public double calcularArea(){
        return this.ancho*this.alto;
    }
}
