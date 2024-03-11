public class Main {
    public static void main(String[] args) {
        Libro miLibro = new Libro("percy jackson", "alfredo", 1998, false);

        // prestamos el libro
        miLibro.prestarLibro();

        // intentamos prestar el libro otra vez
        miLibro.prestarLibro();

        // devolvemos el libro
        miLibro.devolverLibro();
    }
}
