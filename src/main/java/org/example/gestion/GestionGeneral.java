package org.example.gestion;
import java.util.Collection;
/**
 * Clase que gestiona la ejecución de los menús y la interacción con el usuario en el sistema de gestión.
 * Contiene métodos para mostrar el menú principal, manejar las opciones seleccionadas por el usuario y mostrar listas de objetos.
 */
public class GestionGeneral {

    /**
     * Muestra el menú principal y maneja la lógica de navegación según la opción seleccionada por el usuario.
     * Dependiendo de la opción elegida, se llama a los menús correspondientes de gestión de animales, familias o adopciones.
     * También permite salir del sistema cuando el usuario elige la opción 0.
     */

    public static void menuPrincipal(){

        int opcion=0;

        do{
            Menus.menuPrincipal();

            opcion = Teclado.nextInt();

            switch (opcion){
                case 1:
                    GestionAnimales.menuAnimales();
                    break;
                case 2:
                    GestionFamilias.menuFamilias();
                    break;
                case 3:
                    GestionAdopciones.menuAdopciones();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }

        }while(true);

    }
    /**
     * Imprime los elementos de una lista pasada como parámetro.
     * Este metodo itera sobre una colección y muestra cada elemento en consola.
     *
     * @param lista La colección de elementos que se desea imprimir.
     *              Esta colección puede ser una lista, conjunto, etc.
     */
    public static void imprimirListas(Collection lista){

        for(var aux:lista) System.out.println(aux);

    }
}
