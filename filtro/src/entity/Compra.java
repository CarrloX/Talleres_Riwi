package entity;

public class Compra {

    private int id_compra;

    private int id_cliente;

    private int id_procucto;

    private String fecha_compra;

    private int cantidad;
    private Cliente objCliente;
    private Cliente cliente;

    private Producto objProducto;
    private Producto producto;

    public Compra(){
    }

    public Compra(int idCliente, Cliente clienteSeleccion, int idProducto, Producto productoSeleccion, String fechaCompra, int cantidad) {
        this.fecha_compra=fechaCompra;;
    }

    public Compra(int id_compra, int id_cliente, int id_procucto, String fecha_compra, int cantidad, Cliente objCliente, Cliente cliente, Producto objProducto, Producto producto) {
        this.id_compra = id_compra;
        this.id_cliente = id_cliente;
        this.id_procucto = id_procucto;
        this.fecha_compra = fecha_compra;
        this.cantidad = cantidad;
        this.objCliente = objCliente;
        this.cliente = cliente;
        this.objProducto = objProducto;
        this.producto = producto;
    }



    public Cliente getObjCliente() {
        return objCliente;
    }

    public void setObjCliente(Cliente objCliente) {
        this.objCliente = objCliente;
    }

    public Producto getObjProducto() {
        return objProducto;
    }

    public void setObjProducto(Producto objProducto) {
        this.objProducto = objProducto;
    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }


    public int getId_procucto() {
        return id_procucto;
    }

    public void setId_procucto(int id_procucto) {
        this.id_procucto = id_procucto;
    }

    public String getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(String fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return
                "Fecha de compra: " + fecha_compra +
                " ,Cantidad: " + cantidad+
                " ,Cliente: "+objCliente.getNombre()+
                " ,Producto: "+objProducto.getNombre();
    }
}
