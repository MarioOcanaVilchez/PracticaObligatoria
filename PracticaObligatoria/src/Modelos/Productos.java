package Modelos;

public class Productos {
    private String nombre;
    private String descripcion;
    private double precio;
    private int idProducto;
    private static int numProductos = 0;
    private Usuario vendedor;
    private Usuario comprador;
    private boolean enVenta;
//Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


}
