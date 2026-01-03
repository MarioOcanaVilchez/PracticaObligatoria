package Modelos;

public class Productos {
    private String nombre;
    private String descripcion;
    private double precio;
    private final int idProducto;
    private static int numProductos = 0;
    private final Usuario VENDEDOR;
    private Usuario comprador;
    private boolean vendido = false;

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

    public boolean isVendido() {
        return vendido;
    }

    @Override
    public String toString() {
        String estadoVenta = (comprador != null) ? "VENDIDO" : "DISPONIBLE";

        // Formateamos la salida para que sea fácil de escanear en un listado
        String info = String.format(
                "=========================================\n" +
                        "  [P%d] %s (%.2f€) | Estado: %s\n" +
                        "=========================================\n" +
                        "  Descripción: %s\n" +
                        "  Vendedor: %s (Email: %s)\n",
                this.idProducto, this.nombre, this.precio, estadoVenta,
                this.descripcion, this.VENDEDOR.getNombre(), this.VENDEDOR.getEmail()
        );

        // Si está vendido, incluimos el comprador (asumiendo que tiene getters)
        if (comprador != null) {
            info += String.format("  Comprador: %s (Email: %s)\n", comprador.getNombre(), comprador.getEmail());
        }

        return info;
    }
}
