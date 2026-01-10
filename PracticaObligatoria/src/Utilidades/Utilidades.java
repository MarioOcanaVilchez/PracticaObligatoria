package Utilidades;

import java.util.Scanner;

public class Utilidades {
    public static void limpiarPantalla(){
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }
    public static void pulsaParaContinuar(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pulsa una tecla para continuar...");
        scanner.nextLine();
    }
    public static void AnimacionIniciando(){
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
        for (int i = 0; i < 3; i++) {
            System.out.print("Iniciando");
            for (int j = 0; j < 4; j++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (j != 3) System.out.print(".");
            }
            for (int j = 0; j < 100; j++) {
                System.out.println();
            }
        }
    }
    public static boolean validarEntero(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
