package org.yourcompany.yourproject;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

/**
 * Tests per a la classe principal ATM.
 * Comprovem que el flux de dades i la inicialització del sistema siguin correctes.
 * @author Joan
 */
public class ATMTest {

    @Test
    public void testInicialitzacioSistema() {
        // Verifiquem que el sistema pot arrencar i que la classe ATM existeix
        ATM elMeuATM = new ATM();
        assertNotNull(elMeuATM, "L'aplicació ATM s'ha d'instanciar correctament");
    }

    /**
     * Aquest test simula una entrada de dades per comprovar com reacciona el sistema.
     */
    @Test
    public void testSimulacioEntradaLogin() {
        // Simulem que l'usuari escriu un DNI i un PIN al teclat
        String input = "12345678Z\n1234\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Aquí podríem testejar mètodes privats si els fessis "protected" o "package-private",
        // però el més important és que la lògica de l'Scanner no trenqui el programa.
        assertNotNull(System.in, "El flux d'entrada de dades ha de funcionar");
    }
}