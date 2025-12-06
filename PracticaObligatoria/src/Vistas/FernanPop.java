package Vistas;
import Modelos.Productos;
import Modelos.Usuario;
import Utilidades.Utilidades;
import Utilidades.Menus;

import java.util.Scanner;

public class FernanPop {
    static void main() {
        //Iniciamos variables del main
        Scanner scanner = new Scanner(System.in);
        String op, opInicio, clave, usuario, nombre, opCambiarDatos,claveConf,nombreP,descripcion,precioSinValidar;
        double precio;
        boolean continuar;
        int usuarioInicio = 0;
        boolean sesionIniciada;
        Usuario usuario1 = null;
        Usuario usuario2 = null;
        Productos p1u1 = null;
        Productos p2u1 = null;
        Productos p1u2 = null;
        Productos p2u2 = null;

        //Animación de entrada a la app
        Utilidades.AnimacionIniciando();
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
                        } else System.out.println("Número de cuentas máximo actual alcanzado en próximas actualizaciones se añadirán más");
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
                    Utilidades.limpiarPantalla();
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
                            do {
                                opCambiarDatos = Menus.menuCambiarDatos();
                                switch (usuarioInicio) {
                                    case 1:
                                        switch (opCambiarDatos) {
                                            case "1":
                                                System.out.print("Introduce tu nuevo correo: ");
                                                usuario = scanner.nextLine();
                                                if (Usuario.validarUsuario(usuario)) {
                                                    if (usuario1.validarExistenciaCorreo(usuario)) {
                                                        System.out.println("El nuevo correo es el mismo que el antiguo");
                                                    } else {
                                                        System.out.println("Correo actualizado");
                                                        usuario1.setEmail(usuario);
                                                    }
                                                } else {
                                                    System.out.println("Error correo no existente");
                                                }
                                                break;
                                            case "2":
                                                System.out.print("Introduce tu nueva clave: ");
                                                clave = scanner.nextLine();
                                                if (usuario1.validarExistenciaClave(clave))
                                                    System.out.println("La nueva clave no puede ser igual a la antigua");
                                                else {
                                                    System.out.print("Introduce la clave otra vez clave: ");
                                                    claveConf = scanner.nextLine();
                                                    if (usuario1.validarConfirmacionDeClave(clave, claveConf)) {
                                                        usuario1.setClave(clave);
                                                        System.out.println("Clave actualizada");
                                                    } else System.out.println("Error");
                                                }
                                                break;
                                            case "3":
                                                System.out.print("Introduce tu nuevo nombre: ");
                                                nombre = scanner.nextLine();
                                                if (usuario1.validarExistenciaNombre(nombre))
                                                    System.out.println("El nombre no puede ser el mismo al anterior");
                                                else {
                                                    usuario1.setNombre(nombre);
                                                    System.out.println("Nombre actualizado con éxito");
                                                }
                                                break;
                                        }
                                        break;
                                    case 2:
                                        if (usuario2 != null) {
                                            switch (opCambiarDatos) {
                                                case "1":
                                                    System.out.print("Introduce tu nuevo correo: ");
                                                    usuario = scanner.nextLine();
                                                    if (Usuario.validarUsuario(usuario)) {
                                                        if (usuario2.validarExistenciaCorreo(usuario)) {
                                                            System.out.println("El nuevo correo es el mismo que el antiguo");
                                                        } else {
                                                            System.out.println("Correo actualizado");
                                                            usuario2.setEmail(usuario);
                                                        }
                                                    } else {
                                                        System.out.println("Error correo no existente");
                                                    }
                                                    break;
                                                case "2":
                                                    System.out.print("Introduce tu nueva clave: ");
                                                    clave = scanner.nextLine();
                                                    if (usuario2.validarExistenciaClave(clave))
                                                        System.out.println("La nueva clave no puede ser igual a la antigua");
                                                    else {
                                                        System.out.print("Introduce la clave otra vez clave: ");
                                                        claveConf = scanner.nextLine();
                                                        if (usuario2.validarConfirmacionDeClave(clave, claveConf)) {
                                                            usuario2.setClave(clave);
                                                            System.out.println("Clave actualizada");
                                                        } else System.out.println("Error");
                                                    }
                                                    break;
                                                case "3":
                                                    System.out.print("Introduce tu nuevo nombre: ");
                                                    nombre = scanner.nextLine();
                                                    if (usuario2.validarExistenciaNombre(nombre))
                                                        System.out.println("El nombre no puede ser el mismo al anterior");
                                                    else {
                                                        usuario2.setNombre(nombre);
                                                        System.out.println("Nombre actualizado con éxito");
                                                    }
                                                    break;
                                            }
                                            break;
                                        }
                                        if (!opCambiarDatos.equals("4")) {
                                            Utilidades.pulsaParaContinuar();
                                            Utilidades.limpiarPantalla();
                                        }
                                }
                            } while (!opCambiarDatos.equals("4")) ;
                            break;
                        case "3":
                            System.out.println("z");
                            break;
                        case "4":
                            System.out.println();
                            break;
                        case "5":
                            switch (usuarioInicio){
                                case 1:
                                    if (p1u1 == null){
                                        System.out.print("Introduce el nombre del producto: ");
                                        nombreP = scanner.nextLine();
                                        System.out.print("Introduce una descripción del producto: ");
                                        descripcion = scanner.nextLine();
                                        continuar = false;
                                        do {
                                            System.out.print("Introduce un precio al producto: ");
                                            precioSinValidar = scanner.nextLine();
                                            if (!Productos.validarPrecio(precioSinValidar)) {
                                                System.out.println("Precio no válido");
                                            } else {
                                                continuar = true;
                                                precio = Double.parseDouble(precioSinValidar);
                                                p1u1 = new Productos(nombreP,descripcion,precio,usuario1);
                                            }
                                        }while (!continuar);
                                    } else {
                                        if (p2u1 == null){
                                            System.out.print("Introduce el nombre del producto: ");
                                            nombreP = scanner.nextLine();
                                            System.out.print("Introduce una descripción del producto: ");
                                            descripcion = scanner.nextLine();
                                            continuar = false;
                                            do {
                                                System.out.print("Introduce un precio al producto: ");
                                                precioSinValidar = scanner.nextLine();
                                                if (!Productos.validarPrecio(precioSinValidar)) {
                                                    System.out.println("Precio no válido");
                                                } else {
                                                    continuar = true;
                                                    precio = Double.parseDouble(precioSinValidar);
                                                    p2u1 = new Productos(nombreP,descripcion,precio,usuario1);
                                                }
                                            }while (!continuar);
                                        } else System.out.println("Número de productos máximo alcanzado");
                                    }
                                    break;
                                case 2:
                                    if (p1u2 == null){
                                        System.out.print("Introduce el nombre del producto: ");
                                        nombreP = scanner.nextLine();
                                        System.out.print("Introduce una descripción del producto: ");
                                        descripcion = scanner.nextLine();
                                        continuar = false;
                                        do {
                                            System.out.print("Introduce un precio al producto: ");
                                            precioSinValidar = scanner.nextLine();
                                            if (!Productos.validarPrecio(precioSinValidar)) {
                                                System.out.println("Precio no válido");
                                            } else {
                                                continuar = true;
                                                precio = Double.parseDouble(precioSinValidar);
                                                p1u2 = new Productos(nombreP,descripcion,precio,usuario2);
                                            }
                                        }while (!continuar);
                                    } else {
                                        if (p2u2 == null){
                                            System.out.print("Introduce el nombre del producto: ");
                                            nombreP = scanner.nextLine();
                                            System.out.print("Introduce una descripción del producto: ");
                                            descripcion = scanner.nextLine();
                                            continuar = false;
                                            do {
                                                System.out.print("Introduce un precio al producto: ");
                                                precioSinValidar = scanner.nextLine();
                                                if (!Productos.validarPrecio(precioSinValidar)) {
                                                    System.out.println("Precio no válido");
                                                } else {
                                                    continuar = true;
                                                    precio = Double.parseDouble(precioSinValidar);
                                                    p2u2 = new Productos(nombreP,descripcion,precio,usuario2);
                                                }
                                            }while (!continuar);
                                        } else System.out.println("Número de productos máximo alcanzado");
                                    }
                                    break;
                            }
                            break;
                        case "9":
                            break;
                    }
                    if (!op.equals("9") && !op.equals("2")){
                        Utilidades.pulsaParaContinuar();
                    }
                    if (!op.equals("9")){
                        Utilidades.limpiarPantalla();
                    }
                } while (!op.equals("9"));
            }
            if (!opInicio.equals("3")) Utilidades.limpiarPantalla();
        }while (!opInicio.equals("3"));
    }
}