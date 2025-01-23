package org.example.gestion;

/**
 * Clase que contiene los menús principales y específicos para la gestión de animales, familias y adopciones.
 * Los menús son utilizados para mostrar opciones en un sistema de consola para interactuar con el usuario.
 */
public class Menus {

    /**
     * Muestra el menú principal con las opciones disponibles.
     * Las opciones incluyen la gestión de animales, familias, adopciones y salir.
     */
    public static void menuPrincipal() {
        System.out.println("1. Animales");
        System.out.println("2. Familias");
        System.out.println("3. Adopciones");
        System.out.println("0. Salir");
    }

    /**
     * Muestra el menú de gestión de animales con las opciones disponibles.
     * Las opciones incluyen la creación, eliminación, actualización de estado y visualización de animales.
     */
    public static void menuAnimales() {
        System.out.println("1. Nuevo animal");
        System.out.println("2. Eliminar animal");
        System.out.println("3. Actualizar estado animal");
        System.out.println("4. Mostrar animales");
        System.out.println("5. Mostrar animales por especie");
        System.out.println("0. Volver atrás");
    }

    /**
     * Muestra el menú de gestión de familias con las opciones disponibles.
     * Las opciones incluyen la creación, eliminación y visualización de familias.
     */
    public static void menuFamilias() {
        System.out.println("1. Nueva familia");
        System.out.println("2. Eliminar familia");
        System.out.println("3. Mostrar familias");
        System.out.println("0. Volver atrás");
    }

    /**
     * Muestra el menú de gestión de adopciones con las opciones disponibles.
     * Las opciones incluyen la creación, eliminación y visualización de adopciones.
     */
    public static void menuAdopciones() {
        System.out.println("1. Nueva adopcion");
        System.out.println("2. Eliminar adopcion");
        System.out.println("3. Mostrar adopciones");
        System.out.println("0. Volver atrás");
    }
}
