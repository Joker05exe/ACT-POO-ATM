package org.yourcompany.yourproject;

/**
 * Aquesta classe representa els usuaris del banc.
 * He posat molta canya a les validacions perquè no ens entrin dades brutes.
 * @author Joan
 */
public class Client {

    private String dni;
    private String nom;
    private String pin;
    private int intentsFallits;
    private boolean bloquejat;

    /**
     * Constructor per crear un client nou. 
     * Al principi, com és lògic, no està bloquejat i té 0 intents.
     */
    public Client(String dni, String nom, String pin)  {
        this.setNom(nom);
        this.setPin(pin);
        this.setDni(dni);
        this.bloquejat = false;
        this.intentsFallits = 0;
    }

    public String getNom() {
        return nom;
    }

    /**
     * Control d'errors: no vull noms buits o massa curts.
     */
    public void setNom(String nom) {
        if (nom.length() < 3){
            throw new IllegalArgumentException("Vinga, posa un nom de veritat (mínim 3 caràcters)"); 
        }
        this.nom = nom;
    }

    public String getDni() {
        return dni;
    }
    
    /**
     * Aquí m'he currat l'algoritme de validació oficial del DNI.
     */
    public void setDni(String dni) {
        // Taula oficial de lletres per comprovar el DNI
        char[] lletres = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z',
        'S','Q','V','H','L','C','K','E'};

        if (dni == null) {
            throw new IllegalArgumentException("El DNI no pot estar buit");
        }
        if (dni.length() != 9) {
            throw new IllegalArgumentException("Un DNI ha de tenir exactament 9 caràcters");
        }       
        
        int numero;
        try {
            // Intento agafar els primers 8 caràcters com a número
            numero = Integer.parseInt(dni.substring(0, 8));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Els primers 8 caràcters han de ser números!");
        }

        // Calculo la lletra que li pertoca segons el número
        char lletraCorrecta = lletres[numero % 23];       
        char lletraDni = dni.toUpperCase().charAt(8);

        // Si la lletra no quadra, el DNI és inventat
        if (lletraDni != lletraCorrecta) {
            throw new IllegalArgumentException("Aquesta lletra no quadra amb el número de DNI");
        }

        this.dni = dni.toUpperCase();
    }

    /**
     * Validació del PIN: només 4 números.
     */
    public void setPin(String pin)  {
        if(pin == null) throw new IllegalArgumentException("El pin no pot ser null");
        
        if(pin.length() != 4) throw new IllegalArgumentException("El PIN ha de ser de 4 xifres");
        
        try {           
            Integer.parseInt(pin); // Si no és número, saltarà al catch          
            this.pin = pin;
        }
        catch(NumberFormatException e) {
            throw new IllegalArgumentException("El PIN només pot contenir números");
        }       
    }

    public int getIntentsFallits() {
        return intentsFallits;
    }

    public boolean isBloquejat() {
        return bloquejat;
    }

    /**
     * Aquest mètode és clau per la seguretat. 
     * Si s'equivoquen 3 cops, bloquejo la targeta.
     */
    public boolean comprovarPin(String pinIntroduit) {

        // Si ja t'he bloquejat, ni ho intentis
        if (this.bloquejat) {
            return false;
        }

        // Si el PIN és bo, netegem el comptador d'errors
        if (this.pin.equals(pinIntroduit)) {
            this.intentsFallits = 0; 
            return true;
        }

        // Si s'equivoca, sumo un intent fallit
        this.intentsFallits++;
        if (this.intentsFallits >= 3) {
            this.bloquejat = true;
            System.out.println("S'han superat els 3 intents. Compte bloquejat!");
        }
        return false;
    }

    public void resetIntents(){
        this.intentsFallits = 0;
    }

    @Override
    public String toString() {
        // Una manera neta de veure les dades del client per consola
        return "Client: " + nom + " | DNI: " + dni + " | Estat: " + (bloquejat ? "BLOQUEJAT" : "Actiu");
    }

    public String getPin() {
        return pin;
    }
}