package dijkstraAlgorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DijkstraAlgorithm {
    private static WeightedGraph graph;
    private static Map<String, Integer>costs;
    private static Map<String, String> parents;
    private static Set<String> processed;

    public static void main(String[] args){
        setup();

        System.out.println(dijkstraAlgorithm());
    }

    public static Map<String, String> dijkstraAlgorithm(){
        //найти минимальную вершину
        String next = getMinCostVertex();
        while (next!=null){
            //обновить стоимость соседей и родители
            Map<String, Integer> neighbours = graph.getChildren(next);
            int nextCost = costs.get(next);
            for (Map.Entry<String, Integer> e:neighbours.entrySet()) {
                int newCost = nextCost + e.getValue();
                Integer previousCost = costs.get(e.getKey());
                if (previousCost != null && newCost < previousCost){
                    costs.put(e.getKey(),newCost);
                    parents.put(e.getKey(), next);
                }
            }
            //добавить в обработанные
            processed.add(next);
            //найти минимальную вершину
            next = getMinCostVertex();
        }
        return parents;
    }

    private static String getMinCostVertex() {
        if (processed.containsAll(graph.getAllVertexes())){
            return null;
        }
        return costs.entrySet().stream().filter(e -> !processed.contains(e.getKey()))
                .min((e1, e2)->Integer.min(e1.getValue(), e2.getValue())).get().getKey();
    }

    private static void setup(){
        graph = new WeightedGraph();
        graph.addAllVertexes("start", "A", "B", "finish");
        graph.addEdge("start", "A", 6);
        graph.addEdge("start", "B", 2);
        graph.addEdge("B", "A", 3);
        graph.addEdge("A", "finish", 1);
        graph.addEdge("B", "finish", 5);

        costs = new HashMap<>();
        costs.put("A", 6);
        costs.put("B", 2);
        costs.put("finish", Integer.MAX_VALUE);

        parents = new HashMap<>();
        parents.put("A", "start");
        parents.put("B", "start");
        parents.put("finish", null);

        processed = new HashSet<>();
        processed.add("start");
    }

}
