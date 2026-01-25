package Osservatorio.model;

import java.util.*;
import java.util.stream.Collectors;

public final class GestioneDati {
    private static LinkedList<Stato> stati = new LinkedList<>();
    private static LinkedList<Stato> scarti = new LinkedList<>();

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
