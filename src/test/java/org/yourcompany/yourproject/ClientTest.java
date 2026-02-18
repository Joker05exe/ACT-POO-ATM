package org.yourcompany.yourproject;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ClientTest {

    @Test
    public void testBloqueigPin() {
        Client c = new Client("12345678Z", "Joan", "1234"); // Posa un DNI vàlid!
        c.comprovarPin("9999");
        c.comprovarPin("9999");
        c.comprovarPin("9999");
        assertTrue(c.isBloquejat(), "El client s'hauria de bloquejar després de 3 intents");
    }

    @Test
    public void testDniInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Client("12345678A", "Joan", "1234"); // Lletra incorrecta
        });
    }
}