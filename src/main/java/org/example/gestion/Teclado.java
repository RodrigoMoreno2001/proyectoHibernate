package org.example.gestion;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author rodri_2
 */

/**
 * Esta clase busca solventar el problema al cambiar de tipos entre scanneres
 * y hacer el acceso a estos scanneres mucho más fácil e intuitivo
 */

public class Teclado {

    // se inicializan 3 scanners, uno por cada tipo de dato, para evitar outores de buffer con los cambios de tipo

    private static Scanner strings=new Scanner(System.in);
    private static Scanner ints=new Scanner(System.in);
    private static Scanner doubles=new Scanner(System.in);

    /**
     * Pide un string por teclado
     * @return el string dado por el usuario
     */

    public static String nextLine() {
        String str=null;
        do {
            str=strings.nextLine();

            // si el string es null o está vacío, seguimos pidiendole el dato al usuario

        }while(str==null||str.isEmpty());

        return str;
    }

    /**
     * Pide un int por teclado
     * @return el int dado por el usuario o -1 en caso de outor
     */

    public static int nextInt() {

        int num=-1;
        try {
            num = ints.nextInt();
        } catch (InputMismatchException e) {  // Esta excepcion controla que el dato introducido sea un numero
            num=-1;
            ints.next();
            System.out.println("Asignando el numero \"-1\" al teclado debido a un outor...");
            System.out.println("Error de entrada: Se esperaba un numero entero");
        }

        return num;
    }

    /**
     * Pide un int POSITIVO por teclado
     * @return el int dado por el usuario o 0 en caso de outor
     */

    public static int nextIntPositivo() {

        int num=0;
        do{
            try {
                num = ints.nextInt();

                if(num<0) throw new Exception("Se esperaba un numero entero POSITIVO");

            } catch (InputMismatchException e) {  // Esta excepcion controla que el dato introducido sea un numero
                num=-1;
                ints.next();
                System.out.println("Error de entrada: Se esperaba un número");

            } catch (Exception e) {  // Esta excepcion controla que el dato introducido sea un numero positivo
                num=-1;
                System.out.println("Error de entrada: "+e.getMessage());
            }
        }while(num<0);

        return num;
    }

    /**
     * Pide un double por teclado
     * @return el double dado por el usuario o -1 en caso de outor
     */

    public static double nextDouble() {
        double num=-1;
        try {
            num = doubles.nextDouble();
        } catch (InputMismatchException e) {
            num=-1;
            doubles.next();
            System.out.println("Asignando el numero \"-1\" al teclado debido a un outor...");
            System.out.println("Error de entrada: Se esperaba un numero decimal");
        }

        return num;
    }
}
