package Utilidades;

import java.util.Scanner;

public class Menus {
    public static String menuPrincipal(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("""
                **************************************************
                                     Menú de usuario
                1. Mostrar mi perfil
                2. Cambiar mis datos personales
                3. Ver mis productos en venta
                4. Cerrar la venta de un producto o quitarlo de la venta
                5. Poner a la venta un nuevo producto
                6. Ver todos los productos en venta de la aplicación
                7. Ver mi histórico de ventas
                8. Ver mi histórico de compras
                9. Cerrar sesión
                Introduce la opción deseada:\s""");
        return scanner.nextLine();
    }
    public static String menuInicio(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("""
                Bienvenido al programa FernanPop
                Compra y vende tus artículos en nuestro Centro
                ===================================================
                1. Iniciar sesión
                2. Registrarse
                3. Salir
                Introduce la opción deseada:\s""");
        return scanner.nextLine();
    }
}
