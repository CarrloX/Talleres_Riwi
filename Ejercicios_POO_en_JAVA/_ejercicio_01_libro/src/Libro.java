public class Libro {
    //1.atributos
    private String titulo;
    private String autor;
    private int publicacion;
    private boolean prestado;

    // constructor
    public Libro(String titulo, String autor, int publicacion, boolean prestado) {
        this.titulo = titulo;
        this.autor = autor;
        this.publicacion = publicacion;
        this.prestado = prestado;
    }
    //metodos getter and setter
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(int publicacion) {
        this.publicacion = publicacion;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    public void prestarLibro() {
        if (!prestado) {
            prestado = true;
            System.out.println("ll libro '" + titulo + "' ha sido prestado.");
        } else {
            System.out.println("el libro '" + titulo + "' ya está prestado.");
        }
    }

    public void devolverLibro() {
        if (prestado) {
            prestado = false;
            System.out.println("el libro '" + titulo + "' ha sido devuelto.");
        } else {
            System.out.println("el libro '" + titulo + "' no está prestado actualmente.");
        }
    }

    public void cambiarEstado() {
        this.prestado = !this.prestado;
        System.out.println("estado del libro actualizado correctamente");
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", publicacion=" + publicacion +
                ", prestado=" + prestado +
                '}';
    }
}
