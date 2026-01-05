package Vistas;
import Modelos.Fernanpop;
import Modelos.Productos;
import Modelos.Transaccion;
import Modelos.Usuario;
import Utilidades.Utilidades;
import Utilidades.Menus;

import java.util.Scanner;

    public class FernanPop {
        public static void main(String[] args){
        //Iniciamos variables del main
            Scanner scanner = new Scanner(System.in);
            String op, opInicio, clave, usuario, nombre, opCambiarDatos,claveConf,nombreP,descripcion,precioSinValidar;
            double precio;
            Usuario uTemp = null;
            boolean continuar;
            boolean sesionIniciada;
            Fernanpop fernanpop = new Fernanpop();

//            //MOCK
//            fernanpop.crearUser("Prueba1@","1234","Sujeto de pruebas");
//            fernanpop.crearUser("Prueba2@","1234","Sujeto de pruebas2");
//            Usuario vendedor = fernanpop.devuelveUsuario("Prueba1@","1234");
//            vendedor.crearProducto("Gafas de sol","Buenas contra el sol", 19.99,vendedor);
//            //Fin MOCK

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
                                if (uTemp.getP1() != null) System.out.println(uTemp.getP1());
                                if (uTemp.getP2() != null) System.out.println(uTemp.getP2());
                                break;
                            case "4":
                                if (uTemp.hayProductosEnVenta()){
                                    System.out.println("Selecciona artículo a eliminar de en venta con esta opción se eliminara el objeto");
                                    System.out.println("1. " + uTemp.getP1().getNombre());
                                    if (uTemp.getP2() != null) System.out.println("2. " + uTemp.getP2().getNombre());
                                    System.out.println("3. Salir");
                                    System.out.println("Selecciona: ");
                                    nombre = scanner.nextLine();
                                    switch (nombre) {
                                        case "1","2":
                                            if (uTemp.eliminarProducto(nombre)) System.out.println("Artículo eliminado de ventas");
                                            else System.out.println("Opción no existente");
                                            break;
                                        case "3":
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
                                //Ver disponibilidad de productos en la app
                                System.out.println("--- PRODUCTOS DISPONIBLES EN LA APLICACIÓN ---");
                                String resumenProductos = fernanpop.pintaTodosLosProductos();
                                if (resumenProductos.isEmpty()) {
                                    System.out.println("No hay productos disponibles para la venta.");
                                    break;
                                }
                                System.out.println(resumenProductos);
                                //Aqui se comprueba que el id que has metido sea el de algun producto
                                String idStr;
                                int idProducto = -1;
                                boolean esNumero = false;
                                do {
                                    System.out.print("Introduce el ID del producto que deseas ver/comprar (o 0 para salir): ");
                                    idStr = scanner.nextLine();
                                    if (Utilidades.validarEntero(idStr)) {
                                        idProducto = Integer.parseInt(idStr);
                                        esNumero = true;
                                    } else {
                                        System.out.println("ID no válido. Debes introducir solo números.");
                                    }
                                } while (!esNumero);
                                if (idProducto == 0) break;
                                Productos productoAComprar = fernanpop.devuelveProductoPorId(idProducto);
                                if (productoAComprar == null) {
                                    System.out.println("Producto no encontrado o no está a la venta.");
                                    break;
                                }
                                //Cuando metes un id valido te da mas info del producto
                                System.out.println("\n--- DETALLE DEL PRODUCTO ---\n");
                                System.out.println(productoAComprar.toString());
                                if (productoAComprar.getVENDEDOR().getEmail().equals(uTemp.getEmail())) {
                                    System.out.println("No puedes comprar tu propio producto.");
                                    break;
                                }
                                // Lógica de compra
                                System.out.print("\n¿Deseas comprar este producto? (s/n): ");
                                String compraOp = scanner.nextLine();
                                if (compraOp.equalsIgnoreCase("s")) {
                                    // Pedir datos de transacción
                                    System.out.print("Introduce el precio final acordado: ");
                                    String precioFinalStr = scanner.nextLine();
                                    double precioFinal = Double.parseDouble(precioFinalStr);
                                    System.out.print("Introduce tu puntuación (1-5): ");
                                    int puntuacion = Integer.parseInt(scanner.nextLine());
                                    System.out.print("Añade un comentario sobre la transacción: ");
                                    String comentario = scanner.nextLine();
                                    String resultadoCompra = fernanpop.comprarProducto(uTemp, productoAComprar, precioFinal, puntuacion, comentario);
                                    System.out.println("\n" + resultadoCompra);
                                } else {
                                    System.out.println("Operación de compra cancelada.");
                                }
                                break;
                            case "7":
                                System.out.println(uTemp.pintaHistoricoCompras());
                                break;
                            case "8":
                                System.out.println(uTemp.pintaHistoricoVentas());
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
                    uTemp = null;
                }
                if (!opInicio.equals("3")) Utilidades.limpiarPantalla();
            }while (!opInicio.equals("3"));
        }
    }



