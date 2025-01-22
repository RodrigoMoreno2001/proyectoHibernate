package org.example.gestion;

public class Menus {
    public static void  menuPrincipal(){
        System.out.println("1. Animales");
        System.out.println("2. Familias");
        System.out.println("3. Adopciones");
        System.out.println("0. Salir");
    }
    public static void  menuAnimales(){
        System.out.println("1. Nuevo animal");
        System.out.println("2. Eliminar animal");
        System.out.println("3. Actualizar estado animal");
        System.out.println("4. Mostrar animales");
        System.out.println("5. Mostrar animales por especie");
        System.out.println("0. Volver atrás");
    }
    public static void  menuFamilias(){
        System.out.println("1. Nueva familia");
        System.out.println("2. Eliminar familia");
        System.out.println("3. Mostrar familias");
        System.out.println("0. Volver atrás");
    }
    public static void  menuAdopciones(){
        System.out.println("1. Nueva adopcion");
        System.out.println("2. Eliminar adopcion");
        System.out.println("3. Mostrar adopciones");
        System.out.println("0. Volver atrás");
    }

}
