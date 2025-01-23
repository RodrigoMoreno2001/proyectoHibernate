package org.example.gestion;
import java.util.Collection;

public class GestionGeneral {
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

    public static void imprimirListas(Collection lista){

        for(var aux:lista) System.out.println(aux);

    }
}
