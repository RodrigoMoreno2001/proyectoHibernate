package org.example.gestion;

import org.example.DAO.FamiliaDAO;
import org.example.entities.Familia;

import java.util.ArrayList;

public class GestionFamilias {

    public static void menuFamilias(){
        FamiliaDAO familiaDAO=new FamiliaDAO();
        /*
        System.out.println("1. Nueva familia");
        System.out.println("2. Eliminar familia");
        System.out.println("3. Mostrar familias");
        System.out.println("0. Volver atrás");
        */
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
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        }while(opcion!=0);
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
}
