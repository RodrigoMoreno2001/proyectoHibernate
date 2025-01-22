package org.example.gestion;

import org.example.DAO.AnimalDAO;
import org.example.DAO.FamiliaDAO;
import org.example.entities.Animal;
import org.example.entities.Familia;

import java.util.ArrayList;

public class GestionGeneral {
    public static void menuPrincipal(){

        int opcion=0;

        do{
            Menus.menuPrincipal();

            opcion = Teclado.nextInt();

            switch (opcion){
                case 1:
                    menuAnimales();
                    break;
                case 2:
                    menuFamilias();
                    break;
                case 3:
                    menuAdopciones();
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

    public static void menuAnimales(){
        /*
        System.out.println("1. Nuevo animal");
        System.out.println("2. Eliminar animal");
        System.out.println("3. Actualizar estado animal");
        System.out.println("4. Mostrar animales");
        System.out.println("5. Mostrar animales por especie");
        System.out.println("0. Volver atrás");*/

        AnimalDAO animalDAO = new AnimalDAO();
        int opcion=0;

        do{
            Menus.menuAnimales();
            opcion = Teclado.nextInt();
            switch (opcion){
                case 1:
                    animalDAO.guardarAnimal(instanciarNuevoAnimal());
                    break;
                case 2:
                    animalDAO.borrarAnimal(seleccionarAnimal());
                    break;
                case 3:
                    animalDAO.modificarAnimal(modificarEstadoAnimal());
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }

        }while(opcion!=0);
    }

    public static Animal modificarEstadoAnimal() {

        String[] estados={"Recién abandonado", "Tiempo en el refugio", "Próximamente en acogida"};
        int opcion=0;

        Animal animal = seleccionarAnimal();

        if(animal==null) return null;

        System.out.println("Introduce el nuevo estado del animal:\n" +
                            "1.- Recién abandonado \n" +
                            "2.- Tiempo en el refugio \n" +
                            "3.- Próximamente en acogida ");

        do{
            opcion=Teclado.nextInt()-1;
        }while(opcion<0 || opcion>2);

        animal.setEstado(estados[opcion]);
        return animal;
    }

    public static void menuFamilias(){

        int opcion=0;

        do{
            Menus.menuFamilias();
            opcion = Teclado.nextInt();
            switch (opcion){
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }

        }while(opcion!=0);
    }

    public static void menuAdopciones(){

        int opcion=0;

        do{
            Menus.menuAdopciones();
            opcion = Teclado.nextInt();
            switch (opcion){
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 0:

                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }

        }while(opcion!=0);
    }

    public static Animal instanciarNuevoAnimal(){
        System.out.println("Introduce el nombre del animal: ");
        String nombre = Teclado.nextLine();
        System.out.println("Introduce la especie del animal: ");
        String especie = Teclado.nextLine();
        System.out.println("Introduce la edad del animal: ");
        Integer edad = Teclado.nextInt();
        System.out.println("Introduce la descripcion del animal: ");
        String descripcion = Teclado.nextLine();
        System.out.println("Introduce el estado del animal: ");
        String estado = Teclado.nextLine();

        return new Animal(null, nombre, especie, edad, descripcion, estado, seleccionarFamilia());
    }

    public static Familia instanciarNuevaFamilia(){
        System.out.println("Introduce el nombre de la familia: ");
        String nombre = Teclado.nextLine();
        System.out.println("Introduce la edad de la familia: ");
        Integer edad = Teclado.nextInt();
        System.out.println("Introduce la ciudad de la familia: ");
        String ciudad = Teclado.nextLine();

        return new Familia(null,nombre,edad,ciudad);
    }

    public static Familia seleccionarFamilia(){

        var familias= new ArrayList<>(new FamiliaDAO().mostrarFamilias());

        if(familias.isEmpty() || familias==null) return null;

        Integer familiaSeleccionada = 0;

        while(familiaSeleccionada<=0 || familiaSeleccionada>familias.size()){

            System.out.println("Introduce la familia del animal: ");

            for(int i=0;i<familias.size();i++){
                System.out.println((i+1)+".- "+familias.get(i));
            }

            familiaSeleccionada = Teclado.nextInt();
        }
        return familias.get(familiaSeleccionada-1);
    }

    public static Animal seleccionarAnimal(){
        var animales= new ArrayList<>(new AnimalDAO().mostrarAnimales());

        if(animales.isEmpty() || animales==null) return null;

        int animalSeleccionado = 0;

        while(animalSeleccionado<=0 || animalSeleccionado>animales.size()){
            System.out.println("Introduce el animal: ");
            for(int i=0;i<animales.size();i++){
                System.out.println((i+1)+". "+animales.get(i));
            }

            animalSeleccionado = Teclado.nextInt();
        }
        return animales.get(animalSeleccionado-1);
    }

}
