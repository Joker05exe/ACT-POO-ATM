package org.yourcompany.yourproject;

/**
 * Aquest és un tipus especial de compte que permet quedar-se en números vermells.
 * Hereta de la classe Compte, però amb el "comodí" del límit de descobert.
 * @author Joan
 */
public class CompteCorrent extends Compte {

    private double limitDescobert;

    /**
     * Constructor complet: definim titular, saldo inicial i el crèdit extra que li donem.
     */
    public CompteCorrent(Client titular, double saldo, double limitDescobert) {
        super(titular, saldo); // Cridem al constructor de la classe pare (Compte)
        this.limitDescobert = limitDescobert;
    }

    /**
     * Constructor per defecte: si no diem el límit, per defecte en deixem 100€.
     */
    public CompteCorrent(Client titular, double saldo) {
        super(titular, saldo);
        this.limitDescobert = 100; // Un marge de confiança estàndard
    }

    /**
     * Aquí sobreescrivim el mètode retirar. 
     * La diferència és que ara el saldo pot baixar de zero fins a arribar al límit de descobert.
     */
    @Override
    public boolean retirar(double quantitat) {
        // La condició canvia: saldo + límit ha de ser suficient per cobrir la retirada
        if (quantitat > 0 && (saldo + limitDescobert) >= quantitat) {
            saldo -= quantitat;
            
            // Registrem el moviment igual que fem al compte normal
            Moviment moviment = new Moviment("Retirada (C.Corrent)", TipusMoviment.RETIRADA, quantitat);
            moviments.add(moviment);
            return true;
        }
        // Si intenta treure més del que li permetem amb el descobert, li diem que no
        return false;
    }

    public double getLimitDescobert() {
        return limitDescobert;
    }

    public void setLimitDescobert(double limitDescobert) {
        this.limitDescobert = limitDescobert;
    }

    /**
     * Mostrem la info del compte aprofitant el que ja fa el pare però afegint el límit.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Compte Corrent [");
        sb.append(super.toString()); // El número, saldo i titular de la classe Compte
        sb.append(", Límit Descobert: ").append(limitDescobert).append("€");
        sb.append(']');
        return sb.toString();
    }
}