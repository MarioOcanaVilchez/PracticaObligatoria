package Modelos;

public class Productos {
    private String nombre;
    private String descripcion;
    private double precio;
    private final int idProducto;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isEnVenta() {
        return enVenta;
    }

    public void setEnVenta(boolean enVenta) {
        this.enVenta = enVenta;
    }
    //Constructor
    public Productos(String nombre, String descripcion, double precio,Usuario vendedor) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        numProductos++;
        idProducto = numProductos;
        enVenta = true;
        this.vendedor = vendedor;
    }
    public static boolean validarPrecio(String precioSinValidar){
        int caracterValido = 0;
        boolean punto = false;
        for (int i = 0; i < precioSinValidar.length(); i++) {
            if (Character.isDigit(precioSinValidar.charAt(i))) caracterValido++;
            else if (precioSinValidar.charAt(i) == '.' && !punto){
                caracterValido++;
                punto = true;
            }
        }
        return caracterValido == precioSinValidar.length();
    }
}
