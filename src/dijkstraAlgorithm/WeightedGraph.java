package dijkstraAlgorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WeightedGraph {
    private Map<String, Map<String,Integer>> graphMap;

    public Set<String> getAllVertexes(){
        return graphMap.keySet();
    }

    public WeightedGraph() {
        this.graphMap = new HashMap<>();
    }

    public void addVertex(String s){
        graphMap.putIfAbsent(s, new HashMap<>());
    }

    public void addAllVertexes(String ... str){
        for (String s:str) {
            addVertex(s);
        }
    }

    public Map<String, Integer> getChildren(String vertex){
        return graphMap.get(vertex);
    }

    public void addEdge(String parent, String child, Integer weigth){
        getChildren(parent).put(child, weigth);
    }


}
