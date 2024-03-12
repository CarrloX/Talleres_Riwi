package ejercicio_04;

public class circulo extends figura {
    private double radio;

    public circulo(double radio) {
        this.radio = radio;
    }

    @Override
    public double calcularArea(){
        return Math.PI * this.radio*this.radio;
    }
}
