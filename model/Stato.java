package Osservatorio.model;

import Osservatorio.resources.Continente;

public class Stato {
    private long economia;
    private Continente continente;


    public long getEconomia() {
        return this.economia;
    }

    public void setEconomia(long economia) {
        this.economia = economia;
    }

    public Continente getContinente() {
        return this.continente;
    }

    public void setContinente(Continente continente) {
        this.continente = continente;
    }
}
