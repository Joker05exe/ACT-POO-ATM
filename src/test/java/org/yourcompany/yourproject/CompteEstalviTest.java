package org.yourcompany.yourproject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class CompteEstalviTest {

    @Test
    public void testRetirarAmbSaldoMinim() {
        Client joan = new Client("12345678Z", "Joan", "1234");
        // Saldo 200€ i saldo mínim obligatori de 100€
        CompteEstalvi ce = new CompteEstalvi(joan, 200.0, 100.0);
        
        // Intentem retirar 150€: hauria de fallar perquè ens quedaríem amb 50€ (menys del mínim)
        assertFalse(ce.retirar(150.0), "No hauria de permetre baixar del saldo mínim");
        
        // Retirem 50€: hauria de funcionar perquè ens queden 150€
        assertTrue(ce.retirar(50.0), "Hauria de permetre retirar si es manté el mínim");
        assertEquals(150.0, ce.getSaldo());
    }
}