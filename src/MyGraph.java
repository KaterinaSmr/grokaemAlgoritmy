import java.util.ArrayList;
import java.util.List;

public class MyGraph {
    private String element;
    private List<MyGraph> adjacencyList;

    public MyGraph(String element, List<MyGraph> adjacencyList) {
        this.element = element;
        this.adjacencyList = adjacencyList;
    }

    public MyGraph(String element) {
        this.element = element;
        this.adjacencyList = new ArrayList<>();
    }

    public void addAdjacentElement(MyGraph g){
        if (adjacencyList == null){
            adjacencyList = new ArrayList<>();
        }
        adjacencyList.add(g);
    }

    public void deleteAdjacentElement(MyGraph g){
        if (adjacencyList!=null){
            adjacencyList.remove(g);
        }
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public List<MyGraph> getAdjacencyList() {
        return adjacencyList;
    }

    public void setAdjacencyList(List<MyGraph> adjacencyList) {
        this.adjacencyList = adjacencyList;
    }

    public MyGraph getAdjacencyElementByName(String name){
        return adjacencyList.stream().filter(g -> g.element.equals(name)).findAny().orElse(null);
    }

    @Override
    public String toString() {
        return "{" + element + "}";
    }
}
