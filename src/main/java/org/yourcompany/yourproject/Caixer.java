package org.yourcompany.yourproject;

/**
 * Aquesta classe és com el "cervell" que connecta l'usuari amb les dades del banc.
 * Aquí és on guardo qui està fent servir el caixer en cada moment.
 * * @author Joan
 */
public class Caixer {

    private Banc banc;
    private Client clientConnectat;

    /**
     * Constructor: Engeguem el caixer connectant-lo al nostre banc per defecte.
     */
    public Caixer() {
        // De moment treballem amb el Banc Central
        banc = new Banc("Banc Central");
        // Al principi no hi ha ningú loguejat, òbviament
        clientConnectat = null;
    }

    /**
     * Mètode per validar l'usuari. Si el banc el troba, el "recordo" durant la sessió.
     */
    public boolean login(String dni, String PIN) {
        clientConnectat = banc.buscarClient(dni, PIN);

        // Si el banc no em retorna cap client, el login ha fallat
        if (clientConnectat == null) {
            return false;
        }
        return true;
    }

    /**
     * Llista tots els comptes que té el client que ara mateix està davant del caixer.
     */
    public boolean mostrarComptes() {
        // Seguretat: si no hi ha ningú, no ensenyem res!
        if (clientConnectat == null) {
            return false;
        }
        banc.mostrarComptesClient(clientConnectat.getDni(), clientConnectat.getPin());
        return true;
    }

    /**
     * Per saber en què s'ha gastat els diners el client en un compte concret.
     */
    public boolean mostrarMoviments(String numeroCompte) {
        if (clientConnectat == null) {
            return false;
        }
        // Li passem la feina al banc, que és qui té els llibres de registre
        banc.mostrarMovimentsCompte(numeroCompte, clientConnectat);
        return true;
    }
    
    /**
     * Posem diners al compte. Aquí no cal ser l'amo del compte per fer un ingrés.
     */
     public boolean ingressar(String numero, double quantitat) {
         if (clientConnectat == null) {
             return false;
         }
         return banc.ingressar(numero, quantitat);
    }

    /**
     * Traiem diners. Aquí el banc sí que comprova que el compte sigui del client loguejat.
     */
    public boolean retirar(String numero, double quantitat) {
        if (clientConnectat == null) {
            return false;
        }
        return banc.retirar(numero, quantitat, clientConnectat);
    }

    /**
     * Movem diners d'un compte origen (que ha de ser de l'usuari) a qualsevol altre.
     */
    public boolean transferir(String numeroOrigen, String numeroDesti, double quantitat) {
        if (clientConnectat == null) {
            return false;
        }
        // Operació delicada: deixem que la lògica del banc ho gestioni tot
        return banc.transferir(numeroOrigen, numeroDesti, quantitat, clientConnectat);
    }
}