package org.yourcompany.yourproject;

import java.util.ArrayList;

/**
 * Aquesta classe gestiona els diners de cada compte.
 * He creat un sistema per generar números de compte automàtics i 
 * una llista per guardar tot el que es fa (ingressos, retirades, etc.).
 * * @author Joan
 */
public class Compte {

    // Atributs per tenir-ho tot controlat
    protected String numero;
    protected double saldo; 
    protected Client titular;
    protected double interesAnual;    
    
    // Aquí guardaré l'historial del compte per si cal revisar-lo
    protected ArrayList<Moviment> moviments = new ArrayList<>();

    // Variables per generar l'IBAN automàticament
    private static int comptador = 1;
    private static final String prefix = "ES100-1111-";

    /**
     * Constructor per defecte: si no em diuen res, genero el número de compte
     * i incremento el comptador per al següent.
     */
    public Compte() {
        this.numero = prefix + comptador;
        comptador++;
    }

    /**
     * Constructor amb dades inicials: el faig servir quan ja sé qui és l'amo
     * i amb quants diners comença.
     */
    public Compte(Client titular, double saldo) {
        this.numero = prefix + comptador;
        comptador++;
        this.saldo = saldo;
        this.titular = titular;
    }

    /**
     * Mètode per sumar diners al saldo. 
     * Sempre comprovo que no em vulguin ingressar quantitats negatives!
     */
    public boolean ingressar(double quantitat) {
        if (quantitat > 0) {
            saldo += quantitat;
            // Registro l'acció per a que quedi constància
            Moviment moviment = new Moviment("Ingres", TipusMoviment.INGRES, quantitat);
            moviments.add(moviment);
            return true;
        }
        return false;
    }

    /**
     * Per treure diners. El més important: que n'hi hagi prou al compte.
     */
    public boolean retirar(double quantitat) {
        if (quantitat > 0 && saldo >= quantitat) {
            saldo -= quantitat;
            // Ho apunto a la llista de moviments
            Moviment moviment = new Moviment("Retirada", TipusMoviment.RETIRADA, quantitat);
            moviments.add(moviment);
            return true;
        }
        return false; // Si no hi ha saldo, l'operació falla
    }

    /**
     * Mètode per moure diners entre comptes. 
     * Simplement aprofito els mètodes de retirar i ingressar que ja he fet.
     */
    public boolean transferir(Compte desti, double quantitat) {
        if (desti == null) return false;
        
        // Si puc retirar els diners del meu compte...
        if (this.retirar(quantitat)) {
            // ...els poso al compte del destí
            if (desti.ingressar(quantitat)) {
                return true;
            } else {
                // Si l'ingrés fallés (molt rar), hauria de tornar els diners (rollback manual)
                this.ingressar(quantitat);
            }
        }
        return false;
    }

    public double mostrarSaldo() {
        return saldo;
    }

    public String mostrarSaldoTXT() {
        return "El saldo actual és de: " + saldo + "€";
    }

    public double getInteresAnual() {
        return interesAnual;
    }

    public void setInteresAnual(double interesAnual) {
        this.interesAnual = interesAnual;
    }

    /**
     * Càlcul de beneficis anuals segons el tipus d'interès.
     */
    public double calculaInteresAnual() {
        // Fórmula: saldo actual + (interès % del saldo)
        this.saldo = this.saldo + (this.interesAnual / 100 * this.saldo);
        return this.saldo;
    }

    public Client getTitular() {
        return titular;
    }

    public String getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public ArrayList<Moviment> getMoviments() {
        return moviments;
    }

    @Override
    public String toString() {
        // Una descripció ràpida del compte per fer debugging
        return "Compte NÚM: " + numero + " | Saldo: " + saldo + "€ | Titular: " + titular.getNom();
    }
}