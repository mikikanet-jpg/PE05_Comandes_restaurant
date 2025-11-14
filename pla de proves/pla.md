| ID   | Prova (Descripció)                         | Rang entrada       | Valor entrada                    | Valor sortida                         | Resultat  | Estat de la prova |
|------|---------------------------------------------|---------------------|-----------------------------------|-----------------------------------------|-----------|--------------------|
| MP01 | Seleccionar opció vàlida                    | 1–4                 | 1                                 | Entrada a 'Nova Comanda'                | Correcte  | OK                 |
| MP02 | Seleccionar opció vàlida                    | 1–4                 | 2                                 | Entrada a 'Actualitzar Comanda'         | Correcte  | OK                 |
| MP03 | Seleccionar opció vàlida                    | 1–4                 | 3                                 | Mostra últim tiquet                     | Correcte  | OK                 |
| MP04 | Sortir del programa                         | 1–4                 | 4                                 | Missatge de comiat i sortir             | Correcte  | OK                 |
| MP05 | Entrada no numèrica                         | Qualsevol           | a                                 | Error: introdueix un número vàlid       | Correcte  | Exception                    |
| MP06 | Número fora de rang                         | No 1–4              | 9                                 | Opció no vàlida                         | Correcte  | Exception                   |
| NC01 | Crear nova comanda                          | Nom vàlid           | Anna                              | Nom registrat                           | Correcte  | OK                    |
| NC02 | Afegir producte                             | Preu>0 Quant>0      | Pizza,10,2                        | Subtotal=20                             | Correcte  | OK                   |
| NC03 | Afegir segon producte                       | Preu>0 Quant>0      | CocaCola,2,1                      | Subtotal=2                              | Correcte  | OK                    |
| NC04 | Finalitzar comanda                          | s/n                 | n                                 | Mostra tiquet                           | Correcte  | OK                  |
| NC05 | Error preu                                  | No numèric          | abc                               | Missatge d’error                        | Correcte  | Exception                   |
| NC06 | Error quantitat                             | No numèric          | aa                                | Missatge d’error                        | Correcte  | Exception                  |
| AC01 | Actualitzar sense comanda prèvia            | -                   | -                                 | Error: no hi ha comanda                 | Correcte  | Exception                   |
| AC02 | Afegir producte a comanda existent          | Preu>0 Quant>0      | Aigua,1,3                         | Total actualitzat                       | Correcte  | OK                    |
| AC03 | Finalitzar actualització                    | s/n                 | n                                 | Mostra tiquet actualitzat               | Correcte  | OK                   |
| PR01 | Nom de producte buit                        | String              |                                   | Accepta i registra línia buida          | A revisar | Exception                   |
| PR02 | Preu decimal                                | Decimal positiu     | 3.75                              | Subtotal correcte                       | Correcte  |  OK                  |
| PR03 | Quantitat 0                                 | >=0                 | 0                                 | Subtotal=0                              | Correcte  | OK                   |
| PR04 | Nom llarg                                   | String>15           | Hamburguesa XXL Especial          | Alineació correcta en tiquet            | Correcte  | OK                    |
| TQ01 | Mostrar tiquet sense comanda                | -                   | -                                 | Error: No hi ha comanda                 | Correcte  | Exception               |
| TQ02 | Mostrar tiquet correcte                     | Comanda existent    | -                                 | Format correcte                         | Correcte  | OK                   |
| TQ03 | Càlcul IVA                                  | Total=100           | 100                               | IVA=10 Total=110                        | Correcte  | OK                   |
