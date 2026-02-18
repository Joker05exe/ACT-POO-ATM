package org.yourcompany.yourproject;

// Imports separats per assegurar que l'IDE els trobi bé
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CompteTest {

    @Test
    public void testLimitDescobert() {
        // Creem les dades de prova
        Client c = new Client("12345678Z", "Joan", "1234");
        CompteCorrent cc = new CompteCorrent(c, 100.0, 50.0);
        
        // Verifiquem que podem treure diners fins al límit de descobert (100 + 50)
        assertTrue(cc.retirar(140.0), "Hauria de permetre retirar fins a 150");
        assertEquals(-40.0, cc.getSaldo(), "El saldo hauria de ser -40");
        
        // Verifiquem que no podem passar del límit
        assertFalse(cc.retirar(20.0), "No hauria de permetre superar el límit de descobert");
    }

    @Test
    public void testSaldoMinimEstalvi() {
        Client c = new Client("12345678Z", "Joan", "1234");
        CompteEstalvi ce = new CompteEstalvi(c, 200.0, 100.0);
        
        // No hauria de deixar baixar del mínim de 100
        assertFalse(ce.retirar(150.0), "No hauria de deixar el saldo per sota del mínim");
        
        // Si retirem 50, ens queden 150 (per sobre de 100), hauria de funcionar
        assertTrue(ce.retirar(50.0), "Hauria de permetre retirar si es manté el mínim");
        assertEquals(150.0, ce.getSaldo());
    }
}