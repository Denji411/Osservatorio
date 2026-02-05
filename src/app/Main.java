package Osservatorio.src.app;

import Osservatorio.src.model.GestioneDati;

public class Main {

    public static void main(String[] args) {

        GestioneDati.leggiFile();

        GestioneDati.statiPerContinente();
        GestioneDati.economiaMediaContinente();
        GestioneDati.economiaMondiale();
        GestioneDati.topPerContinente();
        GestioneDati.minPerContinente();
        GestioneDati.top10StatiPerEconomia();
    }
}

