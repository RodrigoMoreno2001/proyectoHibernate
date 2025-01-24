package org.example.app;

import org.example.gestion.GestionGeneral;

/**
 * Clase principal de la aplicación que ejecuta el menú principal de gestión.
 *
 * Esta clase contiene el metodo `main` que es el punto de entrada de la aplicación.
 * Al ejecutarse, llama al metodo `menuPrincipal` de la clase `GestionGeneral` para
 * iniciar el flujo principal de la aplicación.
 *
 * @author Rodrigo Moreno
 */
public class Main {

    /**
     * Metodo principal que se ejecuta al iniciar la aplicación.
     */
    public static void main(String[] args) {

        // Llama al menú principal de la clase GestionGeneral

        GestionGeneral.menuPrincipal();
    }
}
