package gestion;

import org.example.entities.Animal;
import org.example.gestion.GestionAnimales;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class GestionAnimalesTest {

    /*
    * LOS TEST SE DEBEN EJECUTAR DE UNO EN UNO
    * PARA EVITAR "NoSuchElementException"
    */

    @Test
    void elegirEspecie() {

        String inputSimulado = "3\n0\n1\n";

        InputStream streamOriginal= System.in;

        System.setIn(new ByteArrayInputStream(inputSimulado.getBytes()));


        assertEquals("Pájaro", GestionAnimales.elegirEspecie());
        assertEquals("Perro", GestionAnimales.elegirEspecie());

        System.setIn(streamOriginal);

    }

    @Test
    void seleccionarEstado() {

        /*
        Este input simulado va a proporcionar al Scanner los valores:
        1: Devolverá "Recién abandonado"
        4: Esto no va a devolver nada, desembocará en otra iteración del while
        2: Esto devolverá "Tiempo en el refugio"
        */

        String inputSimulado = "1\n4\n2\n";
        InputStream streamOriginal= System.in;
        System.setIn(new ByteArrayInputStream(inputSimulado.getBytes()));

        // Verificamos que el estado seleccionado sea el correcto
        assertEquals("Recién abandonado", GestionAnimales.seleccionarEstado());
        assertEquals("Tiempo en el refugio",GestionAnimales.seleccionarEstado());

        System.setIn(streamOriginal);
    }

    @Test
    void instanciarNuevoAnimal() {
        String inputSimulado = "rodri\n2\n20\nno\n1\n";
        InputStream streamOriginal = System.in;

        System.setIn(new ByteArrayInputStream(inputSimulado.getBytes()));
        Animal instanciado = GestionAnimales.instanciarNuevoAnimal();
        Animal esperado = new Animal(null, "rodri", "2", 20, "no", "Recién abandonado", null);
        assertEquals(esperado,instanciado);
        System.setIn(streamOriginal);
    }
}