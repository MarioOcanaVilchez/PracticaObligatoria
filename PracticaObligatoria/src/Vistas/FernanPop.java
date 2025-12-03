package Vistas;
import Modelos.Usuario;
import Utilidades.Utilidades;
import Utilidades.Menus;

import java.util.Scanner;

public class FernanPop {
    static void main() {
        //Iniciamos variables del main
        Scanner scanner = new Scanner(System.in);
        String op, opInicio, clave, usuario, nombre;
        int usuarioInicio = 0;
        boolean sesionIniciada;
        //Utilidades.AnimacionIniciando();
        Usuario usuario1 = null;
        Usuario usuario2 = null;
        //Menu para seleccionar el usuario
        do {
            do {
                opInicio = Menus.menuInicio();
                sesionIniciada = false;
                switch (opInicio) {
                    case "1"://Iniciar Sesión
                        System.out.print("Introduce el correo: ");
                        usuario = scanner.nextLine();

                        System.out.print("Introduce la clave: ");
                        clave = scanner.nextLine();
                        if (usuario1 != null && usuario1.validarUsuario(usuario, clave)) {
                            sesionIniciada = true;
                            System.out.println("Bienvenido " + usuario1.getNombre());
                            usuarioInicio = usuario1.getId();
                        } else if (usuario2 != null && usuario2.validarUsuario(usuario, clave)) {
                            sesionIniciada = true;
                            System.out.println("Bienvenido " + usuario2.getNombre());
                            usuarioInicio = usuario2.getId();
                        } else System.out.println("ERROR usuario o clave incorrectas");
                        break;
                    case "2"://Registrarse
                        if (Usuario.getContadorUsuarios() < 2) {
                            System.out.print("Introduce el correo: ");
                            usuario = scanner.nextLine();
                            if (usuario1 != null && usuario.equals(usuario1.getEmail())) {
                                System.out.println("Correo ya registrado");
                            } else {
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
                            }
                        } else
                            System.out.println("Número de cuentas máximo actual alcanzado en próximas actualizaciones se añadirán más");
                        break;
                    case "3":
                        System.out.println("El programa se cerrara");
                        break;
                    default:
                        System.out.println("Opción no válida");
                }
                if (!opInicio.equals("3")) {
                    Utilidades.pulsaParaContinuar();
                    Utilidades.limpiarPantalla();
                }
            } while (!sesionIniciada && !opInicio.equals("3"));
            if (!opInicio.equals("3")) {
                do {
                    //Menu para las funcionalidades del programa
                    op = Menus.menuPrincipal();
                    switch (op) {
                        case "1":
                            switch (usuarioInicio) {
                                case 1:
                                    System.out.println(usuario1);
                                    break;
                                case 2:
                                    System.out.println(usuario2);
                            }
                            break;
                        case "2":
                            System.out.println();
                            break;
                        case "9":
                            break;
                    }
                    if (!op.equals("9")) {
                        Utilidades.pulsaParaContinuar();
                        Utilidades.limpiarPantalla();
                    }
                } while (!op.equals("9"));
            }
            if (!opInicio.equals("3")) Utilidades.limpiarPantalla();
        }while (!opInicio.equals("3"));
    }
}