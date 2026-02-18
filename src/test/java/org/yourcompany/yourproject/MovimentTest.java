package org.yourcompany.yourproject;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class MovimentTest {

    @Test
    public void testRegistreMoviment() {
        // Creem un moviment manualment per veure si es genera bé
        Moviment m = new Moviment("Ingrés de prova", TipusMoviment.INGRES, 100.0);
        
        // Comprovem que s'ha generat una descripció i que no és buida
        assertNotNull(m.toString(), "El mètode toString ha de retornar informació");
        assertTrue(m.toString().contains("100.0"), "El registre ha d'incloure la quantitat");
        assertTrue(m.toString().contains("INGRES"), "El registre ha d'incloure el tipus de moviment");
    }
}