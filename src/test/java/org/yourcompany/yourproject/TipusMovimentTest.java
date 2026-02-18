package org.yourcompany.yourproject;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TipusMovimentTest {

    @Test
    public void testValorsEnum() {
        // Verifiquem que els tres tipus existeixen tal com els hem definit
        assertNotNull(TipusMoviment.valueOf("INGRES"));
        assertNotNull(TipusMoviment.valueOf("RETIRADA"));
        assertNotNull(TipusMoviment.valueOf("TRANSFERENCIA"));
    }
}