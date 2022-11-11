import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class BreadthFirstSearch {
    public static void main(String[] args) {
        MyGraph katya = new MyGraph("Katya");
        katya.setAdjacencyList(new ArrayList<>(List.of(new MyGraph("Bob"),
                new MyGraph("Peggy"),
                new MyGraph("Alisa"),
                new MyGraph("Clair"))));
        katya.getAdjacencyElementByName("Bob").getAdjacencyList().add(new MyGraph("Anudj"));
        katya.getAdjacencyElementByName("Alisa").getAdjacencyList().add(katya.getAdjacencyElementByName("Peggy"));
        katya.getAdjacencyElementByName("Clair").getAdjacencyList().add(new MyGraph("Johny"));
        katya.getAdjacencyElementByName("Clair").getAdjacencyList().add(new MyGraph("Tom"));

        System.out.println("Solution : " + breadthFirstSearch(katya));

    }

    public static MyGraph breadthFirstSearch (MyGraph graph){
        Queue<MyGraph> searchQueue = new ArrayBlockingQueue<>(20);
        searchQueue.addAll(graph.getAdjacencyList());
        while (!searchQueue.isEmpty()){
            MyGraph g = searchQueue.poll();
            System.out.println("next check: " + g);
            if (isSolution(g)){
                return g;
            }
            searchQueue.addAll(g.getAdjacencyList());
            System.out.println("Search queue: " + searchQueue);
        }
        return null;
    }

    public static boolean isSolution(MyGraph graph){
        if (graph.getElement().endsWith("m")){
            return true;
        }
        return false;
    }
}
