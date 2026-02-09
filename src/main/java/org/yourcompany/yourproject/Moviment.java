package org.yourcompany.yourproject;

import java.time.LocalDateTime;

/**
 * Aquesta classe serveix per deixar constància de cada operació.
 * Com si fos el rebut que et dóna el caixer després de cada acció.
 * @author Joan
 */
public class Moviment {

    private LocalDateTime dataHora;
    private String descripcio;
    private TipusMoviment tipusMoviment;
    private double quantitat;

    /**
     * Constructor: cada vegada que creem un moviment, agafem l'hora del sistema.
     * Així no ens hem de preocupar de passar-li la data a mà.
     */
    public Moviment(String descripcio, TipusMoviment tipusMoviment, double quantitat) {

        // Capturo el moment exacte de la transacció
        this.dataHora = LocalDateTime.now();
        this.descripcio = descripcio;
        this.tipusMoviment = tipusMoviment;
        this.quantitat = quantitat;

    }

    /**
     * Mostra els detalls del moviment de forma llegible.
     */
    @Override
    public String toString() {
        // Ho deixo ben estructurat per a que quan es llistin els moviments no sigui un embolic
        return "REGISTRE [" + dataHora + "] | Tipus: " + tipusMoviment + 
               " | Desc: " + descripcio + " | Import: " + quantitat + "€";
    }

}