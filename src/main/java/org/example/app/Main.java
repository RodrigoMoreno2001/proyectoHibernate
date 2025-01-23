package org.example.app;

import org.example.gestion.GestionGeneral;

public class Main {
    public static void main(String[] args) {

        /*
        // sobrescribe el metodo write de System.err
        System.setErr(new PrintStream(System.err) {
            @Override
            public void write(byte[] b, int off, int len) {

            }
        });
        */

        GestionGeneral.menuPrincipal();

    }
}