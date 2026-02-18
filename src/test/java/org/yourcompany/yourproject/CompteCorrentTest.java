package org.yourcompany.yourproject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class CompteCorrentTest {

    @Test
    public void testRetirarAmbDescobert() {
        Client joan = new Client("12345678Z", "Joan", "1234");
        // Saldo 100€ i límit de descobert de 50€ (total disponible 150€)
        CompteCorrent cc = new CompteCorrent(joan, 100.0, 50.0);
        
        // Retirem 140€: hauria de funcionar i deixar el saldo a -40€
        assertTrue(cc.retirar(140.0), "Hauria de permetre retirar diners usant el descobert");
        assertEquals(-40.0, cc.getSaldo(), "El saldo hauria de ser de -40€");
        
        // Intentem retirar 20€ més: hauria de fallar perquè passaríem del límit de 50€
        assertFalse(cc.retirar(20.0), "No hauria de permetre superar el límit de descobert");
    }
}