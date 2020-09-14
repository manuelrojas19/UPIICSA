package mx.ipn.upiicsa.dmoviles.tiendita;

public class Producto {
    private String producto;
    private Double precio;

    public Producto(String producto, Double precio) {

        this.producto = producto;
        this.precio = precio;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
