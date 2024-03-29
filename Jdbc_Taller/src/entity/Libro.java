package entity;

import java.math.BigDecimal;

public class Libro {
    private int idLibro;
    private String titulo;
    private String añoPublicacion;
    private BigDecimal precio;
    private int idAutor;

    public Libro(){
    }

    public Libro(int idLibro, String titulo, String añoPublicacion, BigDecimal precio, int idAutor) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.añoPublicacion = añoPublicacion;
        this.precio = precio;
        this.idAutor = idAutor;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAñoPublicacion() {
        return añoPublicacion;
    }

    public void setAñoPublicacion(String añoPublicacion) {
        this.añoPublicacion = añoPublicacion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "idLibro=" + idLibro +
                ", titulo='" + titulo + '\'' +
                ", añoPublicacion='" + añoPublicacion + '\'' +
                ", precio=" + precio +
                ", idAutor=" + idAutor +
                '}';
    }
}
