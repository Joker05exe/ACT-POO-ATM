package org.yourcompany.yourproject;

/**
 * Aquesta classe és el "cor" del programa. Aquí guardem les llistes
 * de clients i comptes, i definim què es pot fer amb ells.
 * @author Joan
 */
public class Banc {
    private String nom;
    private Client[] clients; // Array on guardem els 5 clients
    private Compte[] comptes; // Array on guardem els 10 comptes

    /**
     * El Constructor: serveix per "donar vida" al banc i omplir-lo de dades
     * de prova només començar.
     */
    public Banc(String nom) {
        this.nom = nom;

        // Creem l'espai per a 5 clients i els fiquem a dins un a un
        this.clients = new Client[5];
        this.clients[0] = new Client("11111111H", "Alex", "1111");
        this.clients[1] = new Client("22222222J", "Ana", "2222");
        this.clients[2] = new Client("33333333P", "Andreu", "3333");
        this.clients[3] = new Client("44444444A", "Pau", "4444");
        this.clients[4] = new Client("55555555K", "Ina", "5555");

        // Creem l'espai per a 10 comptes
        this.comptes = new Compte[10];
        
        // Aquest bucle "for" serveix per no haver d'escriure 10 línies. 
        // Per cada client, li creem un compte corrent i un d'estalvi automàticament.
        int j = 0;
        for (int i = 0; i < clients.length; i++) {
            this.comptes[j++] = new CompteCorrent(clients[i], 100); // Index 0, 2, 4...
            this.comptes[j++] = new CompteEstalvi(clients[i], 100); // Index 1, 3, 5...
        }
    }

    // --- MÈTODES DE CONFIGURACIÓ (Getters i Setters) ---

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        // El .trim() treu els espais en blanc dels costats per si l'usuari s'equivoca
        if (nom == null || nom.trim().length() < 4) {
            throw new IllegalArgumentException("Ei! El nom del banc és massa curt.");
        }
        this.nom = nom;
    }

    // --- MÈTODES PER BUSCAR I VALIDAR ---

    /**
     * Només diu si el client existeix o no (true/false).
     */
    public boolean validarClient(String dni, String pin) {
        // Si buscarClient ens torna alguna cosa que NO és nul, és que és vàlid
        return buscarClient(dni, pin) != null;
    }

    /**
     * Aquest és important: recorre tots els clients buscant el DNI 
     * i comprovant si el PIN coincideix.
     */
    public Client buscarClient(String dni, String pin) {
        for (Client cli : clients) {
            // Primer mirem si el DNI coincideix
            if (cli != null && cli.getDni().equals(dni)) {
                // Si el DNI és correcte, mirem si el PIN també ho és
                return cli.comprovarPin(pin) ? cli : null;
            }
        }
        return null; // Si acaba el bucle i no hem trobat res, tornem null
    }

    // --- OPERACIONS AMB ELS COMPTES ---

    /**
     * Busca tots els comptes que té un client i els ensenya per consola.
     */
    public void mostrarComptesClient(String dni, String pin) {
        Client c = buscarClient(dni, pin);
        if (c != null) {
            for (Compte compte : comptes) {
                // Comparem objectes: si el titular del compte és el client 'c'
                if (compte != null && compte.getTitular().equals(c)) {
                    System.out.println(compte);
                }
            }
        }
    }

    /**
     * Mostra la llista de moviments (ingressos/retirades) d'un compte concret.
     */
    public void mostrarMovimentsCompte(String numeroCompte, Client clientConnectat) {
        for (Compte c : comptes) {
            // Verifiquem dues coses: que el número de compte existeixi I que sigui del client que ha fet login
            if (c != null && c.getNumero().equals(numeroCompte) && c.getTitular().equals(clientConnectat)) {
                System.out.println("Moviments de: " + numeroCompte);
                for (Moviment m : c.getMoviments()) {
                    System.out.println(m);
                }
                return; // Parem el mètode perquè ja hem acabat
            }
        }
        System.out.println("Error: No tens accés a aquest compte.");
    }

    public boolean ingressar(String numero, double quantitat) {
        for (Compte c : comptes) {
            if (c != null && c.getNumero().equals(numero)) {
                return c.ingressar(quantitat); // Deleguem l'ingrés a la classe Compte
            }
        }
        return false;
    }

    public boolean retirar(String numero, double quantitat, Client clientConnectat) {
        for (Compte c : comptes) {
            // Molt important comprovar que el clientConnectat és realment l'amo!
            if (c != null && c.getNumero().equals(numero) && c.getTitular().equals(clientConnectat)) {
                return c.retirar(quantitat);
            }
        }
        return false;
    }

    /**
     * Mou diners d'un compte a un altre.
     */
    public boolean transferir(String numeroOrigen, String numeroDesti, double quantitat, Client clientConnectat) {
        Compte origen = null;
        Compte desti = null;

        // Busquem els dos objectes Compte dins de la nostra llista
        for (Compte c : comptes) {
            if (c == null) continue;
            if (c.getNumero().equals(numeroOrigen)) origen = c;
            if (c.getNumero().equals(numeroDesti)) desti = c;
        }

        // Si els hem trobat tots dos i el client és l'amo de l'origen, fem la transferència
        if (origen != null && desti != null && origen.getTitular().equals(clientConnectat)) {
            return origen.transferir(desti, quantitat);
        }
        return false;
    }

    /**
     * Això és per als comptes d'estalvi. Com que "Compte" és general, 
     * fem servir 'instanceof' per saber quins són exactament d'estalvi.
     */
    public void incrementarSaldoMinimComptesEstalvi() {
        for (Compte c : comptes) {
            if (c instanceof CompteEstalvi) {
                // Fem un "casting" (convertim temporalment Compte a CompteEstalvi)
                // per poder fer servir el mètode .setSaldoMinim que només tenen els d'estalvi.
                CompteEstalvi estalvi = (CompteEstalvi) c;
                estalvi.setSaldoMinim(estalvi.getSaldoMinim() + 50);
            }
        }
    }
}