package gestion;

import org.example.entities.Familia;
import org.example.gestion.GestionFamilias;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GestionFamiliasTest {

    @Test
    void instanciarNuevaFamilia(){

        String inputSimulado = "Rodrigo\n70\nMarismillas\n";

        System.setIn(new ByteArrayInputStream(inputSimulado.getBytes()));

        assertEquals(new Familia(null,"Rodrigo",70,"Marismillas"), GestionFamilias.instanciarNuevaFamilia());

    }
}