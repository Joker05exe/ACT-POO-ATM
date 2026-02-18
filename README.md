# Projecte Caixer Automàtic (POO-ATM)

Aquest projecte consisteix en una simulació d'un caixer automàtic funcional programat en **Java**, aplicant conceptes de Programació Orientada a Objectes (POO) com l'herència, el polimorfisme, l'encapsulament i la gestió d'excepcions.

## 👤 Autor
* **Joan**

## 📊 Diagrama de Classes (UML)

Aquí es mostra l'arquitectura del sistema, detallant la jerarquia dels comptes i les relacions entre els mòduls principals:

![Diagrama UML del Projecte](//www.plantuml.com/plantuml/png/fLRDRXit4BxhAGRg8L8I1V5rKHJPIagpW7yCIJaLXJ7YKl8aN58XPrMxgO4UUszFVOBUU-jLRz8dALShQYclx3geB_9oPhxlcuz3WcySe-MoK1ttaVGABHOW53gNCbkQbompOVIKVfBmEaefZ3RYsff20jjIHf4LYe-ub5E-LHAi58nwgU84Tusv-P7q4XQedEnqTXNGDNRvwjQKLfXYXVfs-__AcWyUf0kVEnq0gBL1EZlp2x3x--mOcSGT35ZwE2Sm5QYrjFkCmHorIE1RrA9P4ugavbGmbGaCjn_xu8i2IVVGBfq7O-lLVlz3lobLPkd3_GJMXlA3PLDoUxqmZYtQgqBgyY1w5pTLgOkw6cXJ1F96rneLvMXhkRrSKqXv2IlIuQCV6cgp395kf0qyZtipD5fNEyXjVse77k6V6wCawgZYk3alVBgLpg7jwRAGrZI0dqhKJ5lwt9Hp9O_1Mibalx2uPKhTNMnArDdZEp8WpRxMlKMbY5q2_ZloLfbFfVo0V4JviJqC32r3cxBgT5YpHdj9kkTJCitMv2NnO-PRwIHdjTBs5YmbZpJvzQQv9d9kYZZIM8VpQge51m-zBfQHXryTRacpxb3b9cnBirmPwNMckaJLH5jdN5Gyc1iRMnqdhAnSq4sxbrfWZubBXJQCz4iuaDC_DfXF7yId9hD5xHRIaktbqZ4bE_kUEFG2bV1DP95ZlNueQ8ztZJqqrjwRSaK5yKWwOURIxXaZo-B2nvtpqYkqHlQNEtD4yzWngZN5chUaPwIfEAgtAVfFlKK3yl_rdfar5VSl4MHyPomcS6e4gX6odFcaAC5RRsaboBJl5QPLwHAOLJy1l8csj3NoGtAlGczkasDuVjoQ_gEMf2wBaDbgApl_RZAUxZydurasIKVfVc4sIS-dRyUJyVamIsFKPp0O37p-QJhCBiwdC7hsRZpP_5gbGM-o-NjkINYltYh9DmYYcZh120GhewWmTa6kaFqAf88B5yxNFtlGWq5jH-EnU43B68ONPvSNqsoORNwBvOm82zGCMYwj189ShgJEDtzgGGWBOnbRahedNNZkuRklNxrwtcr68u5hScmieNh8aNGwlV1-R4LaSFR-T9PTddfDitIsPwbBw_V2Fx_ylXllMFC985JSzQPMYLjDUqcX986bT4n6Oz1J1ohOqCmHM22mSY7jpWHKi3jgDL-DSSWOq9AGUfNBm5czvZnXhJEYIvqp7b_GvY_8gHw6IiA9vzUubakSao96hcahc9hpc-gtXakg_V8wMtJ7RFDAJq3KooAyVHhmgA6JoCBe7HaewaTM3FrUWpFgE7X8Vm3VIUUy1LVe6TPXevgXYaWsVpZVBgXdrVcjeKDQvSgz4vtKLqBdhlD6whmirBy0)

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
