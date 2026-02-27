# Projecte Caixer Automàtic (POO-ATM)

Aquest projecte consisteix en una simulació d'un caixer automàtic funcional programat en **Java**, aplicant conceptes de Programació Orientada a Objectes (POO) com l'herència, el polimorfisme, l'encapsulament i la gestió d'excepcions.

## 👤 Autor
* **Joan**

## 📊 Diagrama de Classes (UML)

Aquí es mostra l'arquitectura del sistema, detallant la jerarquia dels comptes i les relacions entre els mòduls principals:

![Diagrama UML del Projecte](UML/img/DiagramadeClasses.png)

## 📊 Diagrama de Actors (UML)
Aquí es mostra l'arquitectura dels actors.

![Diagrama UML del Projecte](UML/img/DiagramadeActors.png)
## 📊 Diagrama de FLUXE de execució LOGIN (UML)

![Diagrama UML del Projecte](UML/img/FluxeLOGIN.png)

## 📊 Diagrama de FLUXE de execució INGRESSAR (UML)
![Diagrama UML del Projecte](UML/img/FluxeINGRESSAR.png)

## 🛠️ Estructura del Projecte

El projecte està organitzat en les següents classes dins del paquet `org.yourcompany.yourproject`:

* **ATM**: Classe principal que conté el mètode `main` i gestiona la interfície d'usuari per consola.
* **Caixer**: Actua com a controlador entre la interfície i la lògica de negoci del banc.
* **Client**: Representa l'usuari, incloent validació de DNI (algoritme real) i control de seguretat del PIN.
* **Compte (Abstracta)**: Classe base per a tots els comptes. Gestiona el saldo, el titular i l'historial de moviments.
* **CompteCorrent**: Extensió de Compte que permet un **límit de descobert**.
* **CompteEstalvi**: Extensió de Compte que obliga a mantenir un **saldo mínim**.
* **Moviment**: Registre detallat de cada operació (Ingrés, Retirada, Transferència) amb marca de temps automàtica.
* **TipusMoviment (Enum)**: Defineix les operacions permeses: `INGRES`, `RETIRADA`, `TRANSFERENCIA`.

## 🚀 Funcionalitats
1.  **Login Segur**: Validació de credencials amb bloqueig de compte després de 3 intents fallits.
2.  **Gestió de Comptes**: Possibilitat de veure el saldo i detalls de diversos comptes.
3.  **Operacions Bancàries**: Ingressos, retirades i transferències entre comptes.
4.  **Historial**: Registre complet de tots els moviments realitzats durant la sessió.
