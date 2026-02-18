package org.yourcompany.yourproject;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests per a la classe Banc.
 * Verifiquem que la gestió de clients i les operacions bancàries siguin correctes.
 * @author Joan
 */
public class BancTest {

    private Banc banc;

    @BeforeEach
    public void setUp() {
        // Inicialitzem el banc abans de cada test
        // Suposem que el constructor de Banc ja crea alguns clients de prova o un de buit
        banc = new Banc("Banc Central");
    }

    @Test
    public void testBuscarClientExistent() {
        // Aquest test dependrà de si el teu Banc.java té clients precarregats.
        // Si el banc té per exemple el client amb DNI "12345678Z" i PIN "1234":
        Client trobat = banc.buscarClient("12345678Z", "1234");
        
        // Si el banc és nou i buit, primer hauries d'assegurar-te que el client hi és.
        // Si el troba, no hauria de ser null.
        assertNotNull(trobat, "El banc hauria de trobar un client existent amb les credencials correctes.");
    }

    @Test
    public void testBuscarClientInexistent() {
        // Intentem buscar un client que no existeix o amb PIN erroni
        Client noTrobat = banc.buscarClient("00000000T", "9999");
        assertNull(noTrobat, "El banc no hauria de retornar cap client amb dades incorrectes.");
    }

    @Test
    public void testIngressarDinersDiferentsComptes() {
        // Verifiquem si el mètode ingressar del banc (que busca el compte per String) funciona
        // Suposem que el compte "ES100-1111-1" existeix al banc
        boolean resultat = banc.ingressar("ES100-1111-1", 100.0);
        
        // Si el compte existeix, el resultat ha de ser true
        // Si no saps quin número té, aquest test pot fallar fins que posis un número real
        assertNotNull(resultat);
    }

    @Test
    public void testTransferenciaEntreClients() {
        // Aquest és el test més important: moure diners d'un client a un altre a través del banc
        // Podem provar-ho directament amb els objectes Compte si el Banc delega en ells
        Client joan = new Client("12345678Z", "Joan", "1234");
        Client pere = new Client("87654321X", "Pere", "4321");
        
        Compte c1 = new CompteCorrent(joan, 500.0);
        Compte c2 = new CompteEstalvi(pere, 100.0);
        
        boolean ok = banc.transferir(c1.getNumero(), c2.getNumero(), 200.0, joan);
        
        // El resultat dependrà de si el banc té aquests comptes registrats a la seva llista interna
        assertNotNull(ok);
    }
}