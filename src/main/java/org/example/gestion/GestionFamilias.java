package org.example.gestion;

import org.example.DAO.FamiliaDAO;
import org.example.entities.Familia;

import java.util.ArrayList;
/**
 * Clase encargada de gestionar las operaciones relacionadas con las familias en el sistema.
 * Ofrece funcionalidades para crear, eliminar y visualizar familias.
 */
public class GestionFamilias {
    /**
     * Muestra el menú de gestión de familias y maneja las opciones seleccionadas por el usuario.
     * Las opciones permiten agregar una nueva familia, eliminar una familia o mostrar todas las familias.
     */
    public static void menuFamilias(){
        FamiliaDAO familiaDAO=new FamiliaDAO();
        int opcion=0;

        do{
            Menus.menuFamilias();
            opcion = Teclado.nextInt();
            switch (opcion){
                case 1:
                    familiaDAO.guardarFamilia(instanciarNuevaFamilia());
                    break;
                case 2:
                    familiaDAO.borrarFamilia(seleccionarFamilia());
                    break;
                case 3:
                    GestionGeneral.imprimirListas(familiaDAO.mostrarFamilias());
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
     * Crea una nueva familia solicitando al usuario información como el nombre, edad y ciudad.
     *
     * @return El nuevo objeto Familia instanciado.
     */

    public static Familia instanciarNuevaFamilia(){
        System.out.println("Introduce el nombre de la familia: ");
        String nombre = Teclado.nextLine();
        System.out.println("Introduce la edad de la familia: ");
        Integer edad = Teclado.nextIntPositivo();
        System.out.println("Introduce la ciudad de la familia: ");
        String ciudad = Teclado.nextLine();

        return new Familia(null,nombre,edad,ciudad);
    }

    /**
     * Permite seleccionar una familia de la lista de familias existentes.
     *
     * @return La familia seleccionada o null si no se seleccionó una familia válida.
     */

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
}
