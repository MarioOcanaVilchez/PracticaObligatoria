package Vistas;
import Modelos.Usuario;
import Utilidades.Utilidades;
import Utilidades.Menus;

import java.util.Scanner;

public class FernanPop {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        String op,opInicio,clave,usuario,nombre;
        boolean sesionIniciada;
        Utilidades.AnimacionIniciando();
        Usuario usuario1 = null;
        Usuario usuario2 = null;
        //Menu para seleccionar el usuario
        do {
            opInicio = Menus.menuInicio();
            sesionIniciada = false;
            switch (opInicio) {
                case "1":
                    System.out.print("Introduce el correo: ");
                    usuario = scanner.nextLine();

                    System.out.print("Introduce la clave: ");
                    clave = scanner.nextLine();
                        if (usuario1 != null && usuario1.validarUsuario(usuario, clave) ){
                            sesionIniciada = true;
                            System.out.println("Bienvenido " + usuario1.getNombre());
                        } else if (usuario2 != null && usuario2.validarUsuario(usuario, clave)){
                            sesionIniciada = true;
                            System.out.println("Bienvenido " + usuario2.getNombre());
                        } else System.out.println("ERROR usuario o clave incorrectas");
                    break;
                case "2":
                    if (Usuario.getContadorUsuarios() < 2) {
                        System.out.print("Introduce el correo: ");
                        usuario = scanner.nextLine();
                        if (Usuario.validarUsuario(usuario)) {
                        System.out.print("Introduce la clave: ");
                        clave = scanner.nextLine();
                        System.out.print("Introduce tu nombre: ");
                        nombre = scanner.nextLine();
                        if (usuario1 == null) usuario1 = new Usuario(usuario, clave, nombre);
                        else if (usuario2 == null) usuario2 = new Usuario(usuario, clave, nombre);
                        } else {
                            System.out.println("Usuario no válido");
                        }
                    } else System.out.println("Número de cuentas máximo actual alcanzado en próximas actualizaciones se añadirán más");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
            Utilidades.pulsaParaContinuar();
            Utilidades.limpiarPantalla();
        }while (!sesionIniciada);
        //Menu para las funcionalidades del programa
        op = Menus.menuPrincipal();
        switch (op){
            case "1":
                System.out.println();
                break;
            case "2":
                break;
        }
    }
}
