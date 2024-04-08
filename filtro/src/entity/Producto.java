package entity;

public class Producto {

    private int id_producto;

    private String nombre;

    private String precio;

    private int id_tienda;

    private Tienda tienda;

    public Producto(String nombre, String precio, int id_tienda, Tienda tienda) {
        this.nombre = nombre;
        this.precio = precio;
        this.id_tienda = id_tienda;
        this.tienda =tienda;
    }

    public Producto() {
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public int getId_tienda() {
        return id_tienda;
    }

    public void setId_tienda(int id_tienda) {
        this.id_tienda = id_tienda;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    @Override
    public String toString() {
        return
                "id_producto=" + id_producto +
                ", nombre=" + nombre +
                ", precio=" + precio +
                ", id_tienda=" + id_tienda;
    }
}
