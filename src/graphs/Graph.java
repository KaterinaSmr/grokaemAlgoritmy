package graphs;

import java.util.*;

public class Graph {
    private Map<Vertex, List<Vertex>> graphMap;

    public Graph() {
        this.graphMap = new HashMap<>();
    }

    public Map<Vertex, List<Vertex>> getGraphMap() {
        return graphMap;
    }

    public void addVertex(String label){
        if (graphMap == null){
            graphMap = new HashMap<>();
        }
        graphMap.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    public void addAllVertexes(String... str){
        for (String s:str) {
            this.addVertex(s);
        }
    }
    public void removeVertex(String label){
        Vertex v = new Vertex(label);
        graphMap.values().stream().forEach(list -> list.remove(v));
        graphMap.remove(v);
    }

    public void addEdge(String l1, String l2) {
        Vertex v1 = new Vertex(l1);
        Vertex v2 = new Vertex((l2));
        graphMap.get(v1).add(v2);
        graphMap.get(v2).add(v1);
    }

    public void removeEdge(String l1, String l2){
        Vertex v1 = new Vertex(l1);
        Vertex v2 = new Vertex((l2));
        if (graphMap.get(v1) != null)
            graphMap.get(v1).remove(v2);
        if (graphMap.get(v2)!=null){
            graphMap.get(v2).remove(v1);
        }
    }

    public List<Vertex> getAdjacentList (Vertex vertex){
        return graphMap.get(vertex);
    }

    public static Set<Vertex> depthFirstTraversal(Graph graph, Vertex root){
        Set<Vertex> visited = new HashSet<>();
        Stack<Vertex> scanStack = new Stack<>();
        scanStack.push(root);
        while (!scanStack.isEmpty()){
            System.out.println(scanStack);
            Vertex next = scanStack.pop();
            System.out.println(next);
            visited.add(next);
            for (Vertex v : graph.getAdjacentList(next)) {
                if (!visited.contains(v)) {
                    scanStack.push(v);
                }
            }

        }
        return visited;
    }

    public static Set<Vertex> breadthFirstTravers(Graph graph, Vertex root){
        Set<Vertex> visited = new HashSet<>();
        Queue<Vertex> scanQueue = new LinkedList<>();
        scanQueue.add(root);
        while (!scanQueue.isEmpty()){
            System.out.println(scanQueue);
            Vertex next = scanQueue.poll();
            System.out.println(next);
            visited.add(next);
            for (Vertex v :graph.getAdjacentList(next)) {
                if (!visited.contains(v)){
                    scanQueue.add(v);
                }
            }
        }
        return visited;
    }
}
