package Modelos;

import java.time.LocalDate;

public class Fernanpop {
    Usuario u1;
    Usuario u2;


    public Fernanpop() {
        u1 = null;
        u2 = null;
    }

    public Usuario getU1() {
        return u1;
    }

    public void setU1(Usuario u1) {
        this.u1 = u1;
    }

    public Usuario getU2() {
        return u2;
    }

    public void setU2(Usuario u2) {
        this.u2 = u2;
    }

    public boolean buscarUser(String usuario, String clave) {
        if (u1 != null && u1.getEmail().equals(usuario) && u1.getClave().equals(clave)) {
            return true;
        } else return u2 != null && u2.getEmail().equals(usuario) && u2.getClave().equals(clave);
    }

    public Usuario devuelveUsuario(String usuario, String clave) {
        if (u1 != null && u1.getEmail().equals(usuario) && u1.getClave().equals(clave)) {
            return u1;
        } else if (u2 != null && u2.getEmail().equals(usuario) && u2.getClave().equals(clave)) {
            return u2;
        }
        return null;
    }
    public void crearUser(String usuario,String clave,String nombre){
        if (u1 == null) u1 = new Usuario(usuario,clave,nombre);
        else u2 = new Usuario(usuario,clave,nombre);
    }
    public boolean usuarioReguistrado(String email){
        if (u1 != null && u1.getEmail().equals(email)) return true;
        return u2 != null && u2.getEmail().equals(email);
    }

    public Productos devuelveProductoPorId(int idProducto) {
        if (u1 != null) {
            if (u1.getP1() != null && u1.getP1().getIdProducto() == idProducto) return u1.getP1();
            if (u1.getP2() != null && u2.getP2().getIdProducto() == idProducto) return u1.getP2();
        }
        if (u2 != null) {
            if (u2.getP1() != null && u2.getP1().getIdProducto() == idProducto) return u2.getP1();
            if (u2.getP2() != null && u2.getP2().getIdProducto() == idProducto) return u2.getP2();
        }
        return null;
    }

    public String comprarProducto(Usuario comprador, Productos producto, double precioFinal, int puntuacion, String comentario) {
        if (comprador.historicoCompra != null) {
            return "ERROR: Ya tienes un registro de compra. Límite: 1.";
        }
        Usuario vendedor = producto.getVENDEDOR();
        if (vendedor.historicoVenta != null) {
            return "ERROR: El vendedor ya tiene un registro de venta. Límite: 1.";
        }

        producto.setComprador(comprador);
        String fecha = LocalDate.now().toString();
        Transaccion registroVenta = new Transaccion(precioFinal, comprador.getEmail(), puntuacion, comentario, fecha);
        vendedor.agregarVenta(registroVenta);
        Transaccion registroCompra = new Transaccion(precioFinal, vendedor.getEmail(), puntuacion, comentario, fecha);
        comprador.agregarCompra(registroCompra);
        if (vendedor.getP1() == producto) vendedor.eliminarProducto("1");
        else if (vendedor.getP2() == producto) vendedor.eliminarProducto("2");
        return String.format("COMPRA EXITOSA: Has comprado '%s' por %.2f€.", producto.getNombre(), precioFinal);
    }


    @Override
    public String toString() {
        return "Fernanpop{" +
                "u1=" + u1 +
                ", u2=" + u2 +
                '}';
    }
    public String pintaTodosLosProductos(){
        String resultado = "";
        resultado += u1.pintaProductos();
        resultado += u2.pintaProductos();
        return resultado;
    }
}
