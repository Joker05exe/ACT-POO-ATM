package org.yourcompany.yourproject;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

/**
 * Tests per a la classe Caixer.
 * Verifiquem que la sessió d'usuari i les operacions delegades al banc funcionin.
 * @author Joan
 */
public class CaixerTest {

    private Caixer caixer;

    @BeforeEach
    public void setUp() {
        // Inicialitzem un caixer nou abans de cada test
        caixer = new Caixer();
    }

    @Test
    public void testLoginFallit() {
        // Intentem entrar amb dades que no existeixen
        boolean resultat = caixer.login("00000000T", "1234");
        assertFalse(resultat, "El login no hauria de permetre l'accés amb un DNI inexistent.");
    }

    @Test
    public void testOperacionsSenseSessio() {
        // Segons el teu codi, si no hi ha clientConnectat, les operacions han de retornar false
        assertFalse(caixer.mostrarComptes(), "No s'haurien de mostrar comptes si no hi ha sessió.");
        assertFalse(caixer.ingressar("ES100", 50.0), "No es pot ingressar diners sense estar loguejat.");
        assertFalse(caixer.retirar("ES100", 20.0), "No es pot retirar diners sense estar loguejat.");
        assertFalse(caixer.transferir("origen", "desti", 10.0), "No es poden fer transferències sense sessió.");
    }

    @Test
    public void testMostrarMovimentsSenseSessio() {
        // Verifiquem que no es pot accedir a l'historial sense login
        boolean resultat = caixer.mostrarMoviments("ES12345");
        assertFalse(resultat, "No s'haurien de poder consultar moviments sense un client connectat.");
    }
}