package Osservatorio.model;

import Osservatorio.resources.Continente;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class GestioneDati {
    private static final Logger log = LoggerFactory.getLogger(GestioneDati.class);
    private static LinkedList<Stato> stati = new LinkedList<>();
    private static LinkedList<Stato> scarti = new LinkedList<>();

    public static void leggiFile () {
        try {
            List<String> righe = Files.readAllLines(Path.of("Osservatorio.csv"));
            
            for (int i = 1; i < righe.size(); i++) {
                String riga = righe.get(i);
                log.info("Riga Letta");

                Stato s = new Stato(riga);
                log.info("Creato Oggetto Stato")
                if (s.isValido()) {
                    valide.add(s);
                    log.info("Aggiunto in Validi");
                } else {
                    scarti.add(s);
                    log.info("Aggiunto in Scarti");
                }
            }
        } catch (IOException e){
            log.error("Errore di Lettura file csv");
        }
    }

    
    public static int parseRank(String rank) {
        try{
            return Integer.parseInt(rank);
        }catch(IllegalArgumentException e){
            log.warn("Rank non valido!");
            return 0;
        }
    }

    public static long parseEconomy(String gdp) {
        try{
        return Long.parseLong(gdp);
        }catch(IllegalArgumentException e){
            log.warn("GDP non valido");
            return -1;
        }
    }

    public static Continente parseContinente(String s) {
        try{
            return Continente.valueOf(s.toUpperCase());
        }catch(IllegalArgumentException e){
            log.warn("Continente non valido" );
            return null;
        }
    }

    public static void statiPerContinente() {
        System.out.println("=== Stati Validati Per Continente ===");
        
        stati.stream()
            .collect(Collectors.groupingBy(
                Stato::getContinente,
                Collectors.counting()
            ))
            .forEach((sta, n) ->
                System.out.println(sta + ": " + n)
            );
        
        System.out.println();
    }

    public static void economiaMediaContinente() {
        System.out.println("=== Media Economia Per Continente ===");

        stati.stream()
            .collect(Collectors.groupingBy(
                Stato::getContinente,
                Collectors.averagingDouble(Stato::getEconomia)
            ))
            .entrySet().stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .forEach(e ->
                System.out.println(e.getKey() + ": " + e.getValue())
            );

        System.out.println();
    }

    public static void economiaMondiale() {
        long economiaMondiale = stati.stream()
            .mapToLong(Stato::getEconomia)
            .sum();

        System.out.println("=== Economia Mondiale ===");
        System.out.println(economiaMondiale);
    }

    public static void topPerContinente() {
        System.out.println("=== Stati Più Ricchi Per Continente ===");

        stati.stream()
            .collect(Collectors.groupingBy(
                Stato::getContinente,
                Collectors.maxBy(Comparator.comparing(Stato::getEconomia))
            ))
            .forEach((continente, statoOpt) ->
                statoOpt.ifPresent(stato ->
                    System.out.println(continente + ": " + stato)
                )
            );

        System.out.println();
    }

    public static void minPerContinente() {
        System.out.println("=== Stati Più Poveri Per Continente ===");

        stati.stream()
            .collect(Collectors.groupingBy(
                Stato::getContinente,
                Collectors.minBy(Comparator.comparing(Stato::getEconomia))
            ))
            .forEach((continente, statoOpt) ->
                statoOpt.ifPresent(stato ->
                    System.out.println(continente + ": " + stato)
                )
            );

            System.out.println();
    }

    public static void top10StatiPerEconomia() {
        System.out.println("=== Top 10 Stati Più Ricchi ===");

        stati.stream()
            .sorted(Comparator.comparing(Stato::getEconomia))
            .limit(10)
            .forEach(s ->
                System.out.println(s + ": " + s.getEconomia())
            );

        System.out.println();
    }
}
