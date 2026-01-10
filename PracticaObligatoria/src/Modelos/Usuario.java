package Modelos;

public class Usuario {
    private String email;
    private String clave;
    private String nombre;
    private final int id;
    private static int contadorUsuarios = 0;
    private Productos p1;
    private Productos p2;
    private int contProductosEnVenta;
    private static int cont;
    private Transaccion ultimaVenta;
    private Transaccion ultimaCompra;
//Getters y Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (validarUsuario(email)) this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Productos getP1() {
        return p1;
    }


    public Productos getP2() {
        return p2;
    }

    public static int getCont() {
        return cont;
    }

    public Transaccion getUltimaVenta() {
        return ultimaVenta;
    }

    public void setUltimaVenta(Transaccion ultimaVenta) {
        this.ultimaVenta = ultimaVenta;
    }

    public Transaccion getUltimaCompra() {
        return ultimaCompra;
    }

    public void setUltimaCompra(Transaccion ultimaCompra) {
        this.ultimaCompra = ultimaCompra;
    }

    //Constructor
    public Usuario(String email, String clave, String nombre) {
        this.email = email;
        this.clave = clave;
        this.nombre = nombre;
        contadorUsuarios++;
        contProductosEnVenta = 0;
        id = contadorUsuarios;
        p1 = null;
        p2 = null;
        cont = 0;
    }

    public static int getContadorUsuarios() {
        return contadorUsuarios;
    }

    //Otros metodos
    public static boolean validarUsuario(String usuario){
        for (int i = 0; i < usuario.length(); i++) {
            if (usuario.charAt(i) == '@') return true;
        }
        return false;
    }
    public boolean validarExistenciaCorreo(String correo){
        return correo.equals(this.email);
    }
    public boolean validarConfirmacionDeClave(String clave,String claveConf){
        return clave.equals(claveConf) && !clave.equals(this.clave);
    }
    public boolean validarExistenciaClave(String clave){
        return clave.equals(this.clave);
    }
    public boolean validarExistenciaNombre(String nombre){
        return nombre.equals(this.nombre);
    }
    public boolean cojeProducto(){
        return p1 == null || p2 == null;
    }
    public void crearProducto(String nombre, String descripcion, double precio,Usuario utemp ){
        if (p1 == null) {
            p1 = new Productos(nombre, descripcion, precio, utemp);
            contProductosEnVenta++;
        } else if (p2 == null){
            p2 = new Productos(nombre, descripcion, precio, utemp);
            contProductosEnVenta++;
        }
    }
    public boolean hayProductosEnVenta(){
        return contProductosEnVenta > 0;
    }
    public boolean eliminarProducto(String num){
        switch (num){
            case "1":
                if (p1 != null) {
                    p1 = null;
                    contProductosEnVenta--;
                    if (p2 != null){
                        p1 = p2;
                        p2 = null;
                    }
                    return true;
                }
                break;
            case "2":
                if (p2 != null) {
                    p2 = null;
                    contProductosEnVenta--;
                    return true;
                }
                break;

        }
        return false;
    }
    public static double validarPuntuacion(String puntuacionSinValidar){
        double puntuacion = -1;
        boolean punto = false;
        int caracterValido = 0;
        for (int i = 0; i < puntuacionSinValidar.length(); i++) {
            if (Character.isDigit(puntuacionSinValidar.charAt(i))) caracterValido++;
            else if (puntuacionSinValidar.charAt(i) == '.' && !punto){
                caracterValido++;
                punto = true;
            }
        }
        if (caracterValido == puntuacionSinValidar.length()) puntuacion = Double.parseDouble(puntuacionSinValidar);
       if (puntuacion >= 0 && puntuacion <= 5) return puntuacion;
       return -1;
    }

    //toString Provisional
    //En el futuro se mejorara
    @Override
    public String toString() {
        String info = String.format(
                "**************************************************\n" +
                        "** PERFIL DE USUARIO: %s (ID: %d)\n" +
                        "**************************************************\n" +
                        "  Email: %s\n" +
                        "  Nombre: %s\n",
                this.nombre, this.id, this.email, this.nombre
        );

        info += "\n--- PRODUCTOS EN VENTA ---\n";
        if (!hayProductosEnVenta()) {
            info += "  (Ningún producto activo en venta)\n";
        } else {
            info += pintaProductos(1);
        }
        info += "--------------------------------------------------";


        return info;
    }
    public String pintaProductos(int numEmpieza){
        String resultado = "";
        if (p1 != null && p1.getComprador() == null){
            resultado +=numEmpieza + ". " + p1.getNombre() + " " + p1.getPrecio() + "€" + "\n";
            numEmpieza++;
        }
        if (p2 != null && p2.getComprador() == null){
            resultado +=numEmpieza + ". " + p2.getNombre() + " " + p2.getPrecio() + "€" + "\n";
            numEmpieza++;
        }
        cont = numEmpieza;
        return resultado;
    }
    public String pintaDatosProductos(){
        String resultado = "";
        if (p1 != null) resultado += p1;
        if (p2 != null) resultado += p2;
        return resultado;
    }
}
