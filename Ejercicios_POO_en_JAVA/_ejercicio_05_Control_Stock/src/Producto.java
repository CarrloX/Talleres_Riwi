public class Producto {
    private int id;
    private String descripcion;
    private int cantidadEnStock;

    public Producto(int id, String descripcion, int cantidadInicial) {
        this.id = id;
        this.descripcion = descripcion;
        this.cantidadEnStock = cantidadInicial;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCantidadEnStock() {
        return cantidadEnStock;
    }

    public void agregarStock(int cantidad) {
        if (cantidad > 0) {
            cantidadEnStock += cantidad;
            System.out.println("se agregaron " + cantidad + " unidades al stock de " + descripcion);
        } else {
            System.out.println("la cantidad debe ser mas que 0");
        }
    }

    public void quitarStock(int cantidad) {
        if (cantidad > 0 && cantidad <= cantidadEnStock) {
            cantidadEnStock -= cantidad;
            System.out.println("Se quitaron " + cantidad + " unidades del stock de " + descripcion);
        } else if (cantidad <= 0) {
            System.out.println("la cantidad debe ser mas que 0");
        } else {
            System.out.println("no hay suficientes unidades para quitar");
        }
    }


    @java.lang.Override
    public java.lang.String toString() {
        return "Producto{" +
                "id=" + id +
                ", descripcion=" + descripcion +
                ", cantidadEnStock=" + cantidadEnStock +
                '}';
    }
}
