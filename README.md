# Projecte Caixer Automàtic (POO-ATM)

Aquest projecte consisteix en una simulació d'un caixer automàtic funcional programat en **Java**, aplicant conceptes de Programació Orientada a Objectes (POO) com l'herència, el polimorfisme, l'encapsulament i la gestió d'excepcions.

## 👤 Autor
* **Joan**

## 📊 Diagrama de Classes (UML)

Aquí es mostra l'arquitectura del sistema, detallant la jerarquia dels comptes i les relacions entre els mòduls principals:

![Diagrama UML del Projecte](https://www.plantuml.com/plantuml/png/fLR1Rjj64BthAnR98LOLkZqJWH5LLXe1jX58kXL5CLfEr4cMkypiq8YR-dzwxoVanxeKIN4f4ahS6WPaphnvVFjcPkNNNe2bpCt4VoHR04Ekj07lvo9Ckr9mfPtTq9-eVeeWkRDE_y4kHoLSOfGfG7-4FMxamQ1Yr09sRt0oQUBgcUFzvOChMRky0Fjm-BjWzo50dwalaubIgbQWvjlR453DpnSl8AGVLI8OyfAgZGPhaKSG6kWpSgeMuNCCCCk1x0NmtWSMORBxNt-RZl1ac8C5ld7x01y3vCuB0_-UeotF0ghJ2lhp9EwU0f6Ceu98Hk-1HxECGWpZEM6m_ZqojUd7sENQeyZeP0TMf-fdiBgBQKDePU6ihLegmTf3u0YOrJJH-sVcu5fcgVNufNgtkciVfgdQEMSGR5VH6B5el3e3kJrQPSiSsTKbvxWx--gAJjId4gpGuL2PAtS6nyfRV_zJSTG0nxH7szLdw8M-doxkNDE2k7EHsLtGkdmOBCWEWsIbylGD64FYKnMUewamxbE97q163bWhwVVQkhnxY5uNJKYr5EpkWT-HlGYGbHLsMKbohf6C7YKWJnPbjaSHPF-Zhp_xemuxBmnQ6kVgSOcSUzxlQnVtO3BNDgCB2qbfW0ThyBooaD7FRGbcM7RSy5JDcU7XXhoyQcVvQkmYguH2vZXkHWme6D_Jvu7kMNt2Y-aWSgByfUgTS3gsC4zQaASkHBC0jRhlt2SDHfS6Lf7N5zEsOBWdDVV2CP-iYw6Sv1gzTZja6RHhrYlyXdClLSNMoNwYC-EQbrx0t5Ei-V3IMxAKZ-hjYhwfD-z8_h_UTeXxjn48l7KCgRfn6imr26u3A0AWrqo5fk7Y9K95wLlML6tZnmxLQHoOqOAh2TFTJNJWFU4BOzVv41qDRPctoC7nLdU_h9URu-DwkLsjvzVpOs2xdjzjtYpNoxl5QXwplb1hDA39MQ-o5s-Hl_vjDK6LQo-cLtybINziXzcuroF467uBj5bDhaZfKE0yQVhwpm5T_NTrUNdLVl-dglIDXZhWagIPd93hV_t7QlguPkRY_0yXtzeN4CQG5r37cx22TlaakJffzUFaDTgipCs_)

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
