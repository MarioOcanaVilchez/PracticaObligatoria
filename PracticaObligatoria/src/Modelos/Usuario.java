package Modelos;

public class Usuario {
    private String email;
    private String clave;
    private String nombre;
    private int id;
    private static int contadorUsuarios = 0;
//Getters y Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public int getId() {
        return id;
    }
    //Constructor

    public Usuario(String email, String clave, String nombre) {
        this.email = email;
        this.clave = clave;
        this.nombre = nombre;
        contadorUsuarios++;
        id = contadorUsuarios;
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

    //toString Provisional
    //En el futuro se mejorara
    @Override
    public String toString() {
        return "Usuario{" +
                "email='" + email + '\'' +
                ", clave='" + clave + '\'' +
                ", nombre='" + nombre + '\'' +
                ", id=" + id +
                '}';
    }
}
