package Osservatorio.model;

import Osservatorio.resources.Continente;

public class Stato {

    private long economia;
    private Continente continente;
    private String code;
    private int ranking;
    private String nome;

    public Stato(long economia, Continente continente, String code, int ranking, String nome) {
        this.economia = economia;
        this.continente = continente;
        this.code = code;
        this.ranking = ranking;
        this.nome = nome;

    }

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override

    public boolean equals(Object o) {
        if (o instanceof Stato altro) {
            return this.code.equals(altro.code);
        }
        return false;
    }

        @Override
    public int hashCode() {
        int risultato = 17;
        risultato = risultato * 31 + code.hashCode();
        return risultato; 
    }
}
