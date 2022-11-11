package graphs;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("Bob");
        graph.addVertex("Alice");
        graph.addVertex("Mark");
        graph.addVertex("Rob");
        graph.addVertex("Maria");
        graph.addEdge("Bob", "Rob");
        graph.addEdge("Bob", "Alice");
        graph.addEdge("Alice", "Mark");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Maria", "Alice");
        graph.addEdge("Maria", "Rob");

        System.out.println("Depth first : ");
        Graph.depthFirstTraversal(graph, new Vertex("Bob"));

        System.out.println("Bradth first: ");
        Graph.breadthFirstTravers(graph, new Vertex("Bob"));

    }
}
