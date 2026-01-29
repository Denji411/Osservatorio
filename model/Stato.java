package Osservatorio.model;

import Osservatorio.resources.Continente;

public class Stato {
<<<<<<< HEAD
    long economia;
    Continente continente;

    public long getEconomia() {
        return economia;
    }

    public Continente getContinente() {
        return continente;
=======
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
>>>>>>> 9a8086e8beeaf8184c01ba757402d93cc9c04e8b
    }
}
