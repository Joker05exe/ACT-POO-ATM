package org.yourcompany.yourproject;

/**
 * Aquest compte és per als estalviadors. 
 * A diferència del corrent, aquí sempre hem de deixar un mínim de diners 
 * al compte per no quedar-nos a zero.
 * @author Joan
 */
public class CompteEstalvi extends Compte {

    private double saldoMinim;

    /**
     * Constructor: el titular, els diners que posa i el coixí mínim que ha de mantenir.
     */
    public CompteEstalvi(Client titular, double saldo, double saldoMinim) {
        super(titular, saldo); // Passem la feina a la classe pare
        this.saldoMinim = saldoMinim;
    }

    /**
     * Si no ens diuen res, posem un saldo mínim de 100€ per seguretat.
     */
    public CompteEstalvi(Client titular, double saldo) {
        super(titular, saldo);
        this.saldoMinim = 100;
    }

    /**
     * Sobreescrivim retirar: aquí la condició és més estricta.
     * Després de treure els diners, el que quedi ha de ser igual o superior al mínim.
     */
    @Override
    public boolean retirar(double quantitat) {
        // Comprovo que no buidin el compte més del permès
        if (quantitat > 0 && (saldo - quantitat) >= saldoMinim) {
            saldo -= quantitat;
            
            // Registrem el moviment amb una etiqueta clara
            Moviment moviment = new Moviment("Retirada (C.Estalvi)", TipusMoviment.RETIRADA, quantitat);
            moviments.add(moviment);
            return true;
        }
        // Si la resta no dóna el mínim, no els deixo treure els diners
        return false;
    }

    public double getSaldoMinim() {
        return saldoMinim;
    }

    public void setSaldoMinim(double saldoMinim) {
        this.saldoMinim = saldoMinim;
    }

    /**
     * Pintem la info del compte d'estalvi de forma neta.
     */
    @Override
    public String toString() {
        return "Compte Estalvi [" + super.toString() + ", Mínim obligatori: " + saldoMinim + "€]";
    }
}