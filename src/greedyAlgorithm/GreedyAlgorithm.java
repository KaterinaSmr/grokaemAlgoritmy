package greedyAlgorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GreedyAlgorithm {
    public static Set<String> allStates;
    public static Map<String, Set<String>> radioCoverage;
    public static Set<String> finalStations;
    public static Set<String> coveredStates;

    public static void main(String[] args) {
        setUp();

        while (!getUncoveredStates().isEmpty()) {
            String station = getBestCoverageStation();
            coveredStates.addAll(radioCoverage.get(station));
            finalStations.add(station);
        }

        System.out.println(finalStations);
    }

    private static String getBestCoverageStation() {
        Set<String> unusedStations = radioCoverage.keySet();
        if (!finalStations.isEmpty()) {
            unusedStations.removeAll(finalStations);
        }
        int maxCov = 0;
        String maxStation = null;
        for (String s:unusedStations) {
            Set<String> coverage = radioCoverage.get(s);
            int coveredQty = (int)coverage.stream().filter(state -> !coveredStates.contains(state)).count();
            if (coveredQty > maxCov){
                maxCov = coveredQty;
                maxStation = s;
            }
        }
        return maxStation;
    }

    private static Set<String> getUncoveredStates() {
        return allStates.stream().filter(s -> !coveredStates.contains(s)).collect(Collectors.toSet());
    }

    private static void setUp(){
        allStates = new HashSet<>(Set.of("WA", "MT", "ID", "NV", "UT", "OR", "CA", "AZ"));
        radioCoverage = new HashMap<>(Map.of(
                "One", new HashSet<>(Set.of("ID", "NV", "UT")),
                "Two", new HashSet<>(Set.of("WA", "MT", "ID")),
                "Three", new HashSet<>(Set.of("OR", "CA", "NV")),
                "four", new HashSet<>(Set.of("NV", "UT")),
                "five", new HashSet<>(Set.of("CA", "AZ"))
        ));

        coveredStates = new HashSet<>();
        finalStations = new HashSet<>();
    }
}
