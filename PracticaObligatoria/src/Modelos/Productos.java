package Modelos;

public class Productos {
    private String nombre;
    private String descripcion;
    private double precio;
    private final int idProducto;
    private static int numProductos = 0;
    private final Usuario VENDEDOR;
    private Usuario comprador;
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

    //Constructor
    public Productos(String nombre, String descripcion, double precio,Usuario vendedor) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        numProductos++;
        idProducto = numProductos;
        this.VENDEDOR = vendedor;
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

    @Override
    public String toString() {
        return "Productos{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", idProducto=" + idProducto +
                //Poner al usuario comprador y vendedor pero no directamente el objeto que peta por retroalimentación
                '}';
    }
}
