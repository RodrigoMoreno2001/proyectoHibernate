package org.example.gestion;

import org.example.DAO.AnimalDAO;
import org.example.entities.Animal;

import java.util.ArrayList;

/**
 * Clase encargada de gestionar las operaciones relacionadas con los animales en el sistema.
 * Ofrece funcionalidades para crear, eliminar, actualizar el estado y visualizar animales, así como filtrar por especie.
 */

public class GestionAnimales {

    /**
     * Muestra el menú de gestión de animales y maneja las opciones seleccionadas por el usuario.
     * Las opciones permiten agregar un nuevo animal, eliminar un animal, modificar el estado de un animal,
     * mostrar todos los animales o filtrar animales por especie.
     */

    public static void menuAnimales(){

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
                case 4:
                    GestionGeneral.imprimirListas(animalDAO.mostrarAnimales());
                    break;
                case 5:
                    GestionGeneral.imprimirListas(animalDAO.mostrarAnimalesPorEspecie(elegirEspecie()));
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
     * Modifica el estado de un animal seleccionado.
     * Este metodo permite al usuario seleccionar un animal y luego actualizar su estado.
     *
     * @return El animal con el estado modificado o null si no se seleccionó un animal válido.
     */

    public static Animal modificarEstadoAnimal() {

        Animal animal = seleccionarAnimal();

        if(animal==null) return null;

        animal.setEstado(seleccionarEstado());

        return animal;
    }

    /**
     * Muestra un menú para que el usuario seleccione un estado para el animal.
     *
     * @return El estado seleccionado por el usuario.
     */

    public static String seleccionarEstado(){

        final String[] estados={"Recién abandonado", "Tiempo en el refugio", "Próximamente en acogida"};
        int opcion=0;
        do{

            System.out.println("Introduce el nuevo estado del animal:\n" +
                    "1.- Recién abandonado \n" +
                    "2.- Tiempo en el refugio \n" +
                    "3.- Próximamente en acogida ");

            opcion=Teclado.nextInt()-1;

        }while(opcion<0 || opcion>2);

        return estados[opcion];
    }

    /**
     * Permite seleccionar un animal de la lista de animales existentes.
     *
     * @return El animal seleccionado o null si no se seleccionó un animal válido.
     */

    public static Animal seleccionarAnimal(){
        var animales= new ArrayList<>(new AnimalDAO().mostrarAnimales());

        if(animales.isEmpty()) return null;

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

    /**
     * Permite al usuario seleccionar una especie de una lista predefinida.
     *
     * @return La especie seleccionada.
     */

    public static String elegirEspecie() {
        String[] especies ={"Perro","Gato","Pájaro","Cerdo vietnamita","Serpiente","Camaleon","araña"};

        int especieSeleccionada = 0;

        while(especieSeleccionada<=0 || especieSeleccionada>especies.length){

            System.out.println("Introduce la especie del animal: ");

            for(int i=0;i<especies.length;i++){
                System.out.println((i+1)+".- "+especies[i]);
            }

            especieSeleccionada = Teclado.nextInt();
        }

        return especies[especieSeleccionada-1];
    }

    /**
     * Crea un nuevo animal instanciando su nombre, especie, edad, descripción y estado.
     *
     * @return El nuevo objeto Animal instanciado.
     */

    public static Animal instanciarNuevoAnimal(){



        System.out.println("Introduce el nombre del animal: ");
        String nombre = Teclado.nextLine();
        String especie = elegirEspecie();
        System.out.println("Introduce la edad del animal: ");
        Integer edad = Teclado.nextIntPositivo();
        System.out.println("Introduce la descripcion del animal: ");
        String descripcion = Teclado.nextLine();
        String estado = seleccionarEstado();

        return new Animal(null, nombre, especie, edad, descripcion, estado, null);
    }

}
