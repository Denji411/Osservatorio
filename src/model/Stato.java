package Osservatorio.src.model;

import Osservatorio.src.resources.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Stato {
    private static final Logger log = LoggerFactory.getLogger(GestioneDati.class);

    private String code;
    private int ranking;
    private String nome;
    private long economia;
    private Continente continente;
    private boolean valido = true;

    public Stato(String code, int ranking, String nome, long economia, Continente continente) {
        if (code == null || code.length() != 3) {
            log.warn("Codice Stato non valido: " + code);
            valido = false;
        } else {
            this.code = code;
        }

        if (ranking <= 0) {
            log.warn("Ranking Stato non valido: " + ranking);
            valido = false;
        } else {
            this.ranking = ranking;
        }

        if (nome == null || nome.isBlank()) {
            log.warn("Nome Stato non valido: " + nome);
            valido = false;
        } else {
            this.nome = nome;
        }

        if (economia < 0) {
            log.warn("Economia Stato non valida: " + economia);
            valido = false;
        } else {
            this.economia = economia;
        }

        if (continente == null) {
            log.warn("Continente Stato non valido: " + continente);
            valido = false;
        } else {
            this.continente = continente;
        }
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

    public void setValido(boolean valido) {
        this.valido = valido;
    }

    public boolean isValido() {
        return valido;
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
