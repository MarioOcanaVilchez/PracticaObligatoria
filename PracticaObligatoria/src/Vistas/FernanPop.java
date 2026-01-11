package Vistas;
import Modelos.Fernanpop;
import Modelos.Productos;
import Modelos.Transaccion;
import Modelos.Usuario;
import Utilidades.Utilidades;
import Utilidades.Menus;

import java.util.Scanner;

public class FernanPop {
    static void main() {
        //Iniciamos variables del main
        Scanner scanner = new Scanner(System.in);
        String op, opInicio, clave, usuario, nombre, opCambiarDatos,claveConf,nombreP,descripcion,precioSinValidar,opCompra,respuestaComprar,comentario,puntuacionSinValidar;
        double precio, puntuacion;
        Usuario uTemp;
        boolean continuar;
        boolean sesionIniciada;
        Fernanpop fernanpop = new Fernanpop();
        Transaccion transaccion = null;

        //MOCK
        do {
            System.out.print("¿Quieres usar el MOCK?(s/n): ");
            op = scanner.nextLine();
            op = op.toLowerCase();
            if (op.equals("s")) {
                fernanpop.crearUser("Prueba1@", "1234", "Sujeto de pruebas");
                fernanpop.crearUser("Prueba2@", "1234", "Sujeto de pruebas2");
                uTemp = fernanpop.devuelveUsuario("Prueba1@", "1234");
                uTemp.crearProducto("Gafas de sol", "Buenas contra el sol", 19.99, uTemp);
            }
            if (!op.equals("s") && !op.equals("n")) System.out.println("Opción no válida");
            //Fin MOCK
        }while (!op.equals("s") && !op.equals("n"));
        uTemp = null;

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
                        //usuario1= UsuairoData.usuario1();
                        if (fernanpop.buscarUser(usuario, clave)){
                            uTemp = fernanpop.devuelveUsuario(usuario,clave);
                            System.out.println("Bienvenido " + uTemp.getNombre());
                            sesionIniciada = true;
                        } else System.out.println("ERROR usuario o clave incorrectas");
                        break;
                    case "2"://Registrarse
                        if (Usuario.getContadorUsuarios() < 2) {
                            System.out.print("Introduce el correo: ");
                            usuario = scanner.nextLine();
                            if (fernanpop.usuarioReguistrado(usuario)) {
                                System.out.println("Correo ya registrado");
                            } else {
                                if (Usuario.validarUsuario(usuario)) {
                                    System.out.print("Introduce la clave: ");
                                    clave = scanner.nextLine();
                                    System.out.print("Introduce tu nombre: ");
                                    nombre = scanner.nextLine();
                                    fernanpop.crearUser(usuario,clave,nombre);
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
                    switch (op) {
                        case "1":
                            System.out.println(uTemp);
                            break;
                        case "2":
                            do {
                                opCambiarDatos = Menus.menuCambiarDatos();
                                switch (opCambiarDatos) {
                                    case "1":
                                        System.out.print("Introduce tu nuevo correo: ");
                                        usuario = scanner.nextLine();
                                        if (Usuario.validarUsuario(usuario)) {
                                            if (uTemp.validarExistenciaCorreo(usuario)) {
                                                System.out.println("El nuevo correo es el mismo que el antiguo");
                                            } else {
                                                System.out.println("Correo actualizado");
                                                uTemp.setEmail(usuario);
                                            }
                                        } else {
                                            System.out.println("Error correo no existente");
                                        }
                                        break;
                                    case "2":
                                        System.out.print("Introduce tu nueva clave: ");
                                        clave = scanner.nextLine();
                                        if (uTemp.validarExistenciaClave(clave))
                                            System.out.println("La nueva clave no puede ser igual a la antigua");
                                        else {
                                            System.out.print("Introduce la clave otra vez clave: ");
                                            claveConf = scanner.nextLine();
                                            if (uTemp.validarConfirmacionDeClave(clave, claveConf)) {
                                                uTemp.setClave(clave);
                                                System.out.println("Clave actualizada");
                                            } else System.out.println("Error");
                                        }
                                        break;
                                    case "3":
                                        System.out.print("Introduce tu nuevo nombre: ");
                                        nombre = scanner.nextLine();
                                        if (uTemp.validarExistenciaNombre(nombre)) System.out.println("El nombre no puede ser el mismo al anterior");
                                        else {
                                            uTemp.setNombre(nombre);
                                            System.out.println("Nombre actualizado con éxito");
                                        }
                                        break;
                                    case "4":
                                        System.out.println("Volviendo al menú principal");
                                        break;
                                    default:
                                        System.out.println("Opción no existente");
                                        }
                                        if (!opCambiarDatos.equals("4")){
                                            Utilidades.pulsaParaContinuar();
                                            Utilidades.limpiarPantalla();
                                        }

                            } while (!opCambiarDatos.equals("4")) ;
                            break;
                        case "3":
                            if (uTemp.hayProductosEnVenta()) System.out.println(uTemp.pintaDatosProductos());
                            else System.out.println("No hay productos en venta");
                            break;
                        case "4":
                            if (uTemp.hayProductosEnVenta()){
                                System.out.println("Selecciona artículo a eliminar de en venta con esta opción se eliminara el objeto");
                                System.out.println("1. " + uTemp.getP1().getNombre());
                                if (uTemp.getP2() != null) System.out.println("2. " + uTemp.getP2().getNombre());
                                System.out.print("Selecciona (escribe salir para volver al menú): ");
                                    nombre = scanner.nextLine();
                                    nombre = nombre.toLowerCase();
                                    switch (nombre) {
                                        case "1","2":
                                            if (uTemp.eliminarProducto(nombre)) System.out.println("Artículo eliminado de ventas");
                                            else System.out.println("Opción no existente");
                                            break;
                                        case "salir":
                                            break;
                                        default:
                                            System.out.println("Opción no existente");
                                    }
                            } else System.out.println("No hay artículos a la venta");
                            break;
                        case "5":
                            if (uTemp.cojeProducto()){
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
                                        uTemp.crearProducto(nombreP,descripcion,precio,uTemp);
                                    }
                                }while (!continuar);
                            } else System.out.println("Tienes demasiados productos");
                            break;
                        case "6":
                            do {
                                System.out.println("Productos en venta:");
                                System.out.println(fernanpop.pintaTodosLosProductos(uTemp));
                                System.out.print("Selecciona para ver más detalles o pon salir para volver al menú: ");
                                opCompra = scanner.nextLine();
                                if (opCompra.equals("salir")) System.out.println("Volviendo al menú");
                                else {
                                    switch (opCompra) {
                                        case "1", "2", "3", "4":
                                            if (fernanpop.buscarProducto(uTemp,opCompra) != null) {
                                                System.out.println(fernanpop.buscarProducto(uTemp, opCompra));
                                                do {
                                                    System.out.print("¿Deseas comprar este producto? (s/n):");
                                                    respuestaComprar = scanner.nextLine();
                                                    respuestaComprar = respuestaComprar.toLowerCase();
                                                    if (!respuestaComprar.equals("s") && !respuestaComprar.equals("n"))
                                                        System.out.println("Responde solo con s para si o n para no");
                                                }while (!respuestaComprar.equals("s") && !respuestaComprar.equals("n"));
                                                switch (respuestaComprar){
                                                    case "s":
                                                        if (fernanpop.buscarUser(uTemp,fernanpop.buscarProducto(uTemp,opCompra)) == null)
                                                            System.out.println("No puedes comprar tu propio producto");
                                                        else {
                                                            if (!fernanpop.puedeComprarse(fernanpop.buscarProducto(uTemp,opCompra)))
                                                                System.out.println("El producto ya se ha vendido");
                                                            else {
                                                                System.out.print("Escribe un comentario acerca del producto y del vendedor:");
                                                                comentario = scanner.nextLine();
                                                                do {
                                                                    System.out.print("Introduce una valoración de 0 a 5 estrellas: ");
                                                                    puntuacionSinValidar = scanner.nextLine();
                                                                    puntuacion = Usuario.validarPuntuacion(puntuacionSinValidar);
                                                                    if (puntuacion == -1)
                                                                        System.out.println("Puntuación no válida debe ser un número del 0 al 5");
                                                                } while (puntuacion == -1);
                                                                transaccion = new Transaccion(comentario, puntuacion, uTemp, fernanpop.buscarProducto(uTemp, opCompra));
                                                                uTemp.setUltimaCompra(transaccion);
                                                                fernanpop.aniadirTransaccionVendedor(fernanpop.buscarProducto(uTemp, opCompra), transaccion);
                                                                fernanpop.setCompradorProducto(uTemp, fernanpop.buscarProducto(uTemp, opCompra));
                                                                System.out.println("Operación realizada con éxito");
                                                            }
                                                        }
                                                        break;
                                                    case "n":
                                                        System.out.println("Operación cancelada");
                                                        break;
                                                }
                                            }
                                            else System.out.println("Opción no existente");
                                            break;
                                        default:
                                            System.out.println("Opción no existente");
                                    }
                                }
                                if (!opCompra.equals("salir")){
                                    Utilidades.pulsaParaContinuar();
                                    Utilidades.limpiarPantalla();
                                }
                            }while (!opCompra.equals("salir"));
                            break;
                        case "7":
                            if (uTemp.getUltimaVenta() != null) System.out.println(uTemp.getUltimaVenta().historicoVenta());
                            else System.out.println("No has hecho ninguna venta");
                            break;
                        case "8":
                            if (uTemp.getUltimaCompra() != null) System.out.println(uTemp.getUltimaCompra().historicoCompra());
                            else System.out.println("No has hecho ninguna compra");
                        case "9":
                            break;
                    }
                    if (!op.equals("9") && !op.equals("2") && !op.equals("6")){
                        Utilidades.pulsaParaContinuar();
                    }
                    if (!op.equals("9")){
                        Utilidades.limpiarPantalla();
                    }
                } while (!op.equals("9"));
                uTemp = null;
            }
            if (!opInicio.equals("3")) Utilidades.limpiarPantalla();
        }while (!opInicio.equals("3"));
    }
}