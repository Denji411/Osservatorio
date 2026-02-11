# Osservatorio

Compilazione: javac -cp "lib/*" -d bin src/**/*.java
Esecuzione: java -cp "lib/*:bin" app.Main
Pulizia: rm bin/*/*.class

statiPerContinente: Fornisice il numero di stati che sono stati registrati correttamente per ogni continente.
                    Può essere utile per controllare il numero mancante di stati oppure la presenza di una correlazione validità-continente.

economiaMediaContinente: Fornisce la media economica per ogni continente.
                         Può essere utile per capire quali sono i continenti più poveri e quali sono quelli più ricchi.

economiaMondiale: Fornisce la media economica mondiale.
                  Può essere utile per capire se un continente è sopra o sotto la media mondiale o anche per misurarte il benessere mondiale.

topPerContinente: Fornisce gli stati più ricchi per ogni continente.
                  Può essere utile per individuare i principali poli economici mondiali.

minPerContinente: Fornisce gli stati più poveri per ogni continente.
                  Può essere utile per evidenziare le aree con maggiori difficoltà economiche.