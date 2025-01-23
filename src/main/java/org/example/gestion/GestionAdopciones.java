package org.example.gestion;

import org.example.DAO.AnimalDAO;
import org.example.entities.Animal;
import org.example.entities.Familia;

public class GestionAdopciones {

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

    private static void eliminarAdopcion(AnimalDAO animalDAO) {

        Animal animal=GestionAnimales.seleccionarAnimal();
        animal.setFamilia(null);
        animalDAO.modificarAnimal(animal);

    }

    public static void realizarAdopcion(AnimalDAO animalDAO){

        Familia familia=GestionFamilias.seleccionarFamilia();
        Animal animal=GestionAnimales.seleccionarAnimal();
        animal.setFamilia(familia);
        animalDAO.modificarAnimal(animal);
    }
}
