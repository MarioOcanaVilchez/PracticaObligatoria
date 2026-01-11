package Modelos;

import java.time.LocalDate;

public class Transaccion {
    private String comentario;
    private LocalDate fecha;
    private double puntuacion;
    private Usuario comprador;
    private Usuario vendedor;
    private double precio;
    private Productos producto;


    public Transaccion(String comentario, double puntuacion, Usuario comprador,Productos producto) {
        this.comentario = comentario;
        this.puntuacion = puntuacion;
        vendedor = producto.getVENDEDOR();
        this.producto = producto;
        this.comprador = comprador;
        precio = producto.getPrecio();
        fecha = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Transaccion{" +
                "comentario='" + comentario + '\'' +
                ", fecha=" + fecha +
                ", puntuacion=" + puntuacion +
                ", comprador=" + comprador +
                ", vendedor=" + vendedor +
                ", precio=" + precio +
                '}';
    }
    public String historicoVenta(){
        return "Producto vendido: " + producto.getNombre() + " " + producto.getPrecio() + "€\n" +
                "email del comprador: " + comprador.getEmail() + "\n" +
                "fecha de compra: " + fecha + "\n" +
                "comentario del comprador: " + comentario + "\n" +
                "puntuación del comprador: " + puntuacion + "/5\n";
    }
    public String historicoCompra(){
        return "Producto comprado: " + producto.getNombre() + " " + producto.getPrecio() + "€\n" +
                "email del vendedor: " + vendedor.getEmail() + "\n" +
                "fecha de compra: " + fecha + "\n" +
                "comentario: " + comentario + "\n" +
                "puntuación: " + puntuacion + "/5\n";
    }
}
