package gestion;

import org.example.entities.Familia;
import org.example.gestion.GestionFamilias;
import org.example.gestion.Teclado;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
* La clase Teclado gestiona TODAS las entradas en mi programa.
* */

class TecladoTest {

    @Test
    void nextLine() {
        String inputSimulado = "Rodrigo\nMoreno";

        System.setIn(new ByteArrayInputStream(inputSimulado.getBytes()));

        assertEquals("Rodrigo", Teclado.nextLine());
        assertEquals("Moreno", Teclado.nextLine());
    }

    @Test
    void nextInt() {
        String inputSimulado = "20\n-30";

        System.setIn(new ByteArrayInputStream(inputSimulado.getBytes()));

        assertEquals(20, Teclado.nextInt());
        assertEquals(-30, Teclado.nextInt());
    }

    @Test
    void nextIntPositivo() {

        String inputSimulado = "20\n-30\n30";  // ESE "-30" va a tirar una excepcion, pero es totalmente normal

        System.setIn(new ByteArrayInputStream(inputSimulado.getBytes()));

        assertEquals(20, Teclado.nextIntPositivo());
        assertEquals(30, Teclado.nextIntPositivo());

    }

    @Test
    void nextDouble() {

        String inputSimulado = "20,5\n-30,5";

        System.setIn(new ByteArrayInputStream(inputSimulado.getBytes()));

        assertEquals(20.5, Teclado.nextDouble());
        assertEquals(-30.5, Teclado.nextDouble());

    }
}