package org.example.gestion;

public class GestionAdopciones {

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

}
