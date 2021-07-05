import java.util.LinkedList;

/**
 * Each node in the adjacency list holds a vertex,
 * each is represented with a unique id and stores the list of edges
 * from the vertex
 * @param <T> the type of data that each vertex holds
 */
public class Vertex<T> {
    int id;
    T data;
    LinkedList<Edges<T>> edges;

    public Vertex(int id, T data) {
        this.id = id;
        this.data = data;
        edges = new LinkedList<Edges<T>>();
    }

    /**
     * Adds an edge to the edges linked list with the given destination
     * @param dest the destination vertex
     * @param weight the weight of the edge
     */
    public void addEdge(Vertex<T> dest, double weight) {
        edges.add(new Edges<T>(weight, dest));
    }

    /**
     * Removes the edge to the specified destination vertex
     * @param dest destination vertex
     */
    public void removeEdge(Vertex<T> dest) {
        edges.removeIf(e -> e.destination == dest);
    }

    /**
     * Removes all the edges to and from the vertex
     */
    public void removeAllEdges() {
        for (Edges<T> e: edges) {
            edges.remove(e);
        }
    }

}
