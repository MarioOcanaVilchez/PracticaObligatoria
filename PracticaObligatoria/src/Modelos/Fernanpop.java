package Modelos;

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
    public Productos buscarProducto(Usuario uTemp,String numProducto) {
        int num = Integer.parseInt(numProducto);
        int cont = 1;
        if (uTemp == u1){
            if (u2.getP1() != null && u2.getP1().getComprador() == null) {
                if (cont == num) return u2.getP1();
                else cont++;
            }
            if(u2.getP2() != null && u2.getP2().getComprador() == null) {
                if (cont == num) return u2.getP2();
                else cont++;
            }
            if (u1.getP1() != null && u1.getP1().getComprador() == null) {
                if (cont == num) return u1.getP1();
                else cont++;
            }
            if (u1.getP2() != null && u1.getP2().getComprador() == null) {
                if (cont == num) return u1.getP2();
                else return null;
            }
        } else {
            if (u1.getP1() != null && u1.getP1().getComprador() == null) {
                if (cont == num) return u1.getP1();
                else cont++;
            }
            if(u1.getP2() != null && u1.getP2().getComprador() == null) {
                if (cont == num) return u1.getP2();
                else cont++;
            }
            if (u2.getP1() != null && u2.getP1().getComprador() == null) {
                if (cont == num) return u2.getP1();
                else cont++;
            }
            if (u2.getP2() != null && u2.getP2().getComprador() == null) {
                if (cont == num) return u2.getP2();
                else return null;
            }
        }
        return null;
    }
    public boolean usuariosIguales(Usuario usuario, Productos productos){
        return usuario == productos.getVENDEDOR();
    }
    public Usuario buscarUser(Usuario usuario,Productos producto){
        if (usuariosIguales(usuario,producto)) return null;
        if (u1 == producto.getVENDEDOR()) return u1;
        if (u2 == producto.getVENDEDOR()) return u2;
        return null;
    }
    public Usuario buscarUser(Productos productos){
        return productos.getVENDEDOR();
    }
    public void aniadirTransaccionVendedor(Productos productos, Transaccion transaccion){
        Usuario usuario = buscarUser(productos);
        if (usuario == u1) u1.setUltimaVenta(transaccion);
        else if (usuario == u2) u2.setUltimaVenta(transaccion);
    }
    public void setVendedorProducto(Usuario usuario,Productos productos){
        productos.setComprador(usuario);
    }
    public boolean puedeComprarse(Productos productos){
        return productos.getComprador() == null;
    }

    @Override
    public String toString() {
        return "Fernanpop{" +
                "u1=" + u1 +
                ", u2=" + u2 +
                '}';
    }
    public String pintaTodosLosProductos(Usuario uTemp){
        String resultado = "";
        if (uTemp == u1){
            resultado += u2.pintaProductos(1);
            resultado += u1.pintaProductos(Usuario.getCont());
        } else {
            resultado += u1.pintaProductos(1);
            resultado += u2.pintaProductos(Usuario.getCont());
        }
        if (Usuario.getCont() == 1) resultado += "No hay productos a la venta";
        return resultado;
    }
}

