# Connecta 4

Aquest projecte implementa el joc de **Connecta 4** en Java. El joc permet a dos jugadors competir per veure qui pot connectar quatre fitxes consecutives en una graella.

## Estructura del projecte

El projecte té la següent estructura de directoris:
## Estructura del projecte

El projecte té la següent estructura de directoris:

- **Exercici 1/**
  - **cabreraalejandro_main/**
    - `pom.xml`
    - **src/**
      - **main/**
        - **java/**
          - **connecta4/**
            - `Game.java`
            - `Main.java`
            - `Player.java`
            - `Table.java`
        - **resources/**
      - **test/**
        - **java/**
    - **target/**
      - **classes/**
        - **connecta4/**
          - `Game.class`
          - `Main.class`
          - `Player.class`
          - `Table.class`
      - **test-classes/**

## Classes principals

### `Main.java`
La classe **Main** conté el punt d'entrada del programa. Aquí es gestionen les interaccions amb l'usuari, com ara la introducció dels noms dels jugadors i la configuració del taulell.

### `Game.java`
La classe **Game** gestiona la lògica del joc, incloent-hi la verificació de victòries, empats i la realització de tirades.

### `Player.java`
La classe **Player** representa un jugador del joc. Conté informació com el nom del jugador, el nombre de victòries i la fitxa assignada.

### `Table.java`
La classe **Table** representa el taulell del joc. Gestiona la graella on es col·loquen les fitxes.

## Com executar el projecte

Per executar aquest projecte, segueix els passos següents:

1. **Clona el repositori** al teu ordinador.
2. **Obre el projecte** en el teu IDE preferit (per exemple, Visual Studio Code).
3. **Assegura't de tenir Java** instal·lat al teu sistema.
4. **Executa la classe Main** per iniciar el joc.

## Com jugar

1. **Introdueix el nom dels jugadors** quan se't demani.
2. **Configura el taulell**: introdueix el nombre de files i columnes per al taulell (entre 4 i 9).
3. **Torn de cada jugador**: cada jugador introdueix el número de la columna on vol col·locar la seva fitxa durant el seu torn.
4. **Condicions de victòria o empat**: el joc continuarà fins que un jugador connecti quatre fitxes consecutives o es produeixi un empat.
5. **Reiniciar el joc**: després de cada partida, se't preguntarà si vols jugar de nou.

## Contribucions

Les contribucions són benvingudes! Si vols contribuir a aquest projecte:

- Fes un **fork del repositori**.
- Envia una **pull request** amb les teves millores.

## Llicència

Aquest projecte està llicenciat sota la [Llicència MIT](https://opensource.org/licenses/MIT).

---

**Gaudeix jugant a Connecta 4!**
