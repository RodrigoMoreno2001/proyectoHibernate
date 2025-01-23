package org.example.gestion;

import org.example.DAO.AnimalDAO;
import org.example.entities.Animal;
import org.example.entities.Familia;

/**
 * Clase encargada de gestionar las adopciones de animales.
 * Permite realizar adopciones, eliminar adopciones y mostrar animales adoptados.
 * Interactúa con el `AnimalDAO` para modificar los registros de los animales.
 */

public class GestionAdopciones {

    /**
     * Muestra el menú de adopciones y maneja las opciones seleccionadas por el usuario.
     * Dependiendo de la opción, el usuario puede realizar una adopción, eliminar una adopción o ver los animales adoptados.
     */

    public static void menuAdopciones(){

        AnimalDAO animalDAO=new AnimalDAO();

        int opcion=0;

        do{
            Menus.menuAdopciones();
            opcion = Teclado.nextInt();
            switch (opcion){
                case 1:
                    realizarAdopcion(animalDAO);
                    break;
                case 2:
                    eliminarAdopcion(animalDAO);
                    break;
                case 3:
                    GestionGeneral.imprimirListas(animalDAO.mostrarAnimalesAdoptados());
                    break;
                case 0:
                    System.out.println("Volviendo...");
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }

        }while(opcion!=0);
    }

    /**
     * Elimina una adopción al desvincular a un animal de su familia adoptiva.
     * Este metodo selecciona un animal y le asigna un valor nulo en el campo `familia`, luego actualiza la base de datos.
     *
     * @param animalDAO El objeto DAO que gestiona las operaciones de modificación en los registros de los animales.
     */

    private static void eliminarAdopcion(AnimalDAO animalDAO) {

        Animal animal=GestionAnimales.seleccionarAnimal();
        animal.setFamilia(null);
        animalDAO.modificarAnimal(animal);

    }

    /**
     * Realiza una adopción al asociar un animal con una familia.
     * Este metodo selecciona una familia y un animal, luego establece la familia en el campo `familia` del animal,
     * y finalmente actualiza el registro del animal en la base de datos.
     *
     * @param animalDAO El objeto DAO que gestiona las operaciones de modificación en los registros de los animales.
     */

    public static void realizarAdopcion(AnimalDAO animalDAO){

        Familia familia=GestionFamilias.seleccionarFamilia();
        Animal animal=GestionAnimales.seleccionarAnimal();
        animal.setFamilia(familia);
        animalDAO.modificarAnimal(animal);
    }
}
