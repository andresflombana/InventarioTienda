package alosemo.gestordeinventario;

/**
 *
 * Andrés Lombana - Sebastián Moreno
 */
public class Inventario {
    //atributos
    private int idProducto;
    private int precio;
    private String producto;
    private int cantidad;
    //metodos

    public Inventario() {
        
    }

    public Inventario(int idProducto, int precio, String producto, int cantidad) {
        this.idProducto = idProducto;
        this.producto = producto;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    
    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}