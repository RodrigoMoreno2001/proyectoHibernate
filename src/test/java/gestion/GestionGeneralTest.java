package gestion;

import org.example.gestion.GestionGeneral;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GestionGeneralTest {

    @Test
    void imprimirListas() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;

        System.setOut(new PrintStream(outContent));

        try {
            GestionGeneral.imprimirListas(List.of("a", "b", "c"));
            assertEquals("a" + System.lineSeparator() + "b" + System.lineSeparator() + "c" + System.lineSeparator(), outContent.toString());
        } finally {
            System.setOut(originalOut);
        }
    }
}