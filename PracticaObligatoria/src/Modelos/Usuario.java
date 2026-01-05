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
    Transaccion historicoVenta;
    Transaccion historicoCompra;
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

    public void setP1(Productos p1) {
        this.p1 = p1;
    }

    public Productos getP2() {
        return p2;
    }

    public void setP2(Productos p2) {
        this.p2 = p2;
    }

    public int getId() {
        return id;
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
        this.historicoVenta = null;
        this.historicoCompra = null;
    }

    public static int getContadorUsuarios() {
        return contadorUsuarios;
    }

    //Otros metodos
    public boolean validarUsuario(String usuario,String clave){
        return email.equals(usuario) && this.clave.equals(clave);
    }
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

    public void agregarVenta(Transaccion venta) {
        if (this.historicoVenta == null) this.historicoVenta = venta;
    }

    public void agregarCompra(Transaccion compra) {
        if (this.historicoCompra == null) this.historicoCompra = compra;
    }

    public String pintaHistoricoVentas() {
        if (historicoVenta != null) return "--- Histórico de Ventas ---\n" + historicoVenta.toString();
        else return "No hay ventas registradas en el histórico.";
    }

    public String pintaHistoricoCompras() {
        if (historicoCompra != null) return "--- Histórico de Compras ---\n" + historicoCompra.toString();
        return "No hay compras registradas en el histórico.";
    }

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

        // Añadimos los productos en venta de forma estructurada
        info += "\n--- PRODUCTOS EN VENTA ---\n";
        if (contProductosEnVenta == 0) {
            info += "  (Ningún producto activo en venta)\n";
        } else {
            // Llama a pintaProductos() para listar p1 y p2
            info += pintaProductos();
        }
        info += "--------------------------------------------------";

        // NOTA: Para no sobrecargar el perfil, no incluiremos aquí los historicosVenta/Compra,
        // ya que tienen su propia opción de menú (7 y 8).

        return info;
    }

    public String pintaProductos(){
        String resultado = "";
        if (p1 != null)  resultado += p1;
        if (p2 != null)  resultado += p2;
        return resultado;
    }

    public String pintaResumenProductos(){
        String resultado = "";
        if (p1 != null)  resultado += p1.pintaResumen() + "\n";
        if (p2 != null)  resultado += p2.pintaResumen() + "\n";
        return resultado;
    }
}

