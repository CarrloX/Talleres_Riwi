import javax.swing.*;
import java.util.ArrayList;

public class inventario {
    private ArrayList<producto> productos;

    public inventario() {
        this.productos = new ArrayList<>();
    }
    public void agregarProducto(producto producto){
        productos.add(producto);
    }
    public boolean eliminarProducto (int id){
        return productos.removeIf(p->p.getId()==id);
    }

    public String listarProductos() {
        StringBuilder listaProductos = new StringBuilder();
        for (producto p : productos) {
            listaProductos.append("ID: ").append(p.getId()).append(", Nombre: ").append(p.getNombre()).append(", Precio: ").append(p.getPrecio()).append("\n");
        }
        return listaProductos.toString();
    }

}
