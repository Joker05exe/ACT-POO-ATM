/*
 * Projecte: Caixer Automàtic POO
 * Creat per: Joan
 */

package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 * Aquesta és la classe principal del meu caixer. 
 * Bàsicament, aquí controlo el flux de l'usuari i les interaccions per consola.
 * * @author Joan
 */
public class ATM {

    // Eines que faré servir a tot arreu: el teclat i la lògica del caixer
    static Scanner teclat = new Scanner(System.in);
    static Caixer caixer = new Caixer();

    /**
     * El cor del programa. Comencem amb el login i després el bucle del menú.
     */
    public static void main(String[] args) {
    
        // Primer de tot, que s'identifiquin, si no, no entren!
        demanarLogin();
        
        int opcio;
        do { 
           // Els mostro què poden fer
           mostrar_menu();
           opcio = teclat.nextInt();
           
           // Segons el que triïn, executo una acció o una altra
           switch (opcio) {               
            case 1: 
                mostrar_comptes();
                break;
            case 2: 
                mostrar_moviments();
                break;
            case 3: 
                ingressar();
                break;
            case 4: 
                retirar();
                break;
            case 5: 
                transferir();
                break;
            case 6: 
                System.out.println("Gràcies per utilitzar el caixer. Torna aviat!");
                break;
            default: 
                System.out.println("Coi! Aquesta opció no existeix. Prova-ho de nou.");
        }
        } while (opcio != 6);  
    }

    /** * Aquí em poso seriós: si no encerten el DNI i el PIN, es queden aquí tancats.
      */
    private static void demanarLogin() {
        String dni, pin;
        boolean correcte = false;
        
        do {
            System.out.println("--- ACCÉS AL CAIXER ---");
            System.out.print("Introdueix el teu DNI: ");
            dni = teclat.next();
            System.out.print("Ara el teu PIN: ");
            pin = teclat.next();
            
            // Crido al mètode del caixer per veure si les dades són bones
            if (caixer.login(dni, pin)) {
                correcte = true;
                System.out.println("\nTot correcte. Hola de nou!");
            } else {
                System.out.println("Dades incorrectes... torna a provar-ho, si us plau.");
            }
        } while (!correcte);
    } 

    /** * Un menú senzillet perquè no es perdin.
      */
    private static void mostrar_menu() {
        System.out.println("\n--- MENÚ D'OPERACIONS ---");
        System.out.println("1. Veure els meus comptes");
        System.out.println("2. Consultar moviments");
        System.out.println("3. Fer un ingrés");
        System.out.println("4. Traure diners");
        System.out.println("5. Enviar diners (Transferència)");
        System.out.println("6. Sortir i tancar sessió");     
        System.out.print("Què vols fer avui?: ");
    }

    /** * Simplement llistem el que té l'usuari actual.
      */
    private static void mostrar_comptes() {
        caixer.mostrarComptes();
    }

    /** * Li demano quin compte vol mirar i li trec la llista de moviments.
      */
    private static void mostrar_moviments() {
        System.out.print("De quin compte vols veure els moviments?: ");
        String numeroCompte = teclat.next();
        caixer.mostrarMoviments(numeroCompte);
    }    

    /** * Per quan vulguin omplir la guardiola.
      */
    private static void ingressar() {
        System.out.print("Número de compte per l'ingrés: ");
        String numeroCompte = teclat.next();
        System.out.print("Quants diners vols posar?: ");
        double quantitat = teclat.nextDouble();
        
        if (caixer.ingressar(numeroCompte, quantitat)) { 
            System.out.println("Fet! Ingrés completat.");
        } else {
            System.out.println("Alguna cosa ha anat malament. Revisa les dades.");
        }
    }

    /** * Per treure efectiu. Compte amb el saldo!
      */
    private static void retirar() {
        System.out.print("De quin compte vols retirar?: ");
        String numeroCompte = teclat.next();
        System.out.print("Quantitat a treure: ");
        double quantitat = teclat.nextDouble();
        
        if (caixer.retirar(numeroCompte, quantitat)) {
            System.out.println("Aquí tens els teus diners. No els gastis tots de cop!");
        } else {
            System.out.println("Operació cancel·lada. Revisa si tens prou saldo o si el compte és teu.");
        }
    }

    /** * Enviar diners d'un lloc a l'altre. L'operació més complexa.
      */
    private static void transferir() {
        System.out.print("Compte d'on sortiran els diners: ");
        String numeroCompteOrigen = teclat.next();
        System.out.print("Compte on vols enviar-los: ");
        String numeroCompteDestin = teclat.next();
        System.out.print("Import de la transferència: ");
        double quantitat = teclat.nextDouble();
        
        if (caixer.transferir(numeroCompteOrigen, numeroCompteDestin, quantitat)) {
            System.out.println("Transferència enviada amb èxit.");
        } else {
            System.out.println("No s'ha pogut fer el traspàs. Revisa els números de compte.");
        }
    }
}