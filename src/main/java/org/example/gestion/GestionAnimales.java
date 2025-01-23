package org.example.gestion;

import org.example.DAO.AnimalDAO;
import org.example.entities.Animal;

import java.util.ArrayList;

public class GestionAnimales {

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

    public static Animal modificarEstadoAnimal() {

        final String[] estados={"Recién abandonado", "Tiempo en el refugio", "Próximamente en acogida"};
        int opcion=0;

        Animal animal = seleccionarAnimal();

        if(animal==null) return null;

        do{

            System.out.println("Introduce el nuevo estado del animal:\n" +
                    "1.- Recién abandonado \n" +
                    "2.- Tiempo en el refugio \n" +
                    "3.- Próximamente en acogida ");

            opcion=Teclado.nextInt()-1;

        }while(opcion<0 || opcion>2);

        animal.setEstado(estados[opcion]);

        return animal;
    }

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

    private static String elegirEspecie() {
        String[] especies ={"Perro","Gato","Pájaro","Cerdo vietnamita","Serpiente","Camaleon","araña"};

        int especieSeleccionada = 0;

        while(especieSeleccionada<=0 || especieSeleccionada>especies.length){

            System.out.println("Introduce la familia del animal: ");

            for(int i=0;i<especies.length;i++){
                System.out.println((i+1)+".- "+especies[i]);
            }

            especieSeleccionada = Teclado.nextInt();
        }

        return especies[especieSeleccionada-1];
    }

    public static Animal instanciarNuevoAnimal(){
        System.out.println("Introduce el nombre del animal: ");
        String nombre = Teclado.nextLine();
        String especie = elegirEspecie();
        System.out.println("Introduce la edad del animal: ");
        Integer edad = Teclado.nextInt();
        System.out.println("Introduce la descripcion del animal: ");
        String descripcion = Teclado.nextLine();
        System.out.println("Introduce el estado del animal: ");
        String estado = Teclado.nextLine();

        return new Animal(null, nombre, especie, edad, descripcion, estado, null);
    }

}
