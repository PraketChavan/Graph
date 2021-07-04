import java.util.Iterator;
import java.util.LinkedList;

/**
 * Graph represented as a adjacency list. By default the graph will be undirected
 * @param <T> The type of the data that each vertex will hold
 */
public class Graph<T> extends LinkedList<Vertex<T>> {

    public Graph() {
        super();
    }

    /**
     * Adds a vertex to the graph with the id and the given data
     * @param id the id of the vertex
     * @param data the data that the vertex will hold
     */
    public void addVertex(int id, T data) {
        Vertex<T> vertex = new Vertex<>(id, data);
        this.add(vertex);
    }

    /**
     * Removes the vertex from the graph and all the related edges
     * @param id id of the vertex to remove
     * @return vertex that was removed
     */
    public Vertex<T> removeVertex(int id) {
        Vertex<T> v = null;
        for (int i = 0; i < this.size(); i++) {
            if(this.get(i).id == id) {
                v = this.remove(i);
                break;
            }
        }
        //Remove all the related edges.
        return v;
    }

    /**
     * Searches the graph for the vertex with the given id
     * @param id id of the vertex to search
     * @return the vertex object
     */
    public Vertex<T> findVertex(int id) throws Exception{
        Vertex<T> v = null;
        for (Vertex<T> vertex : this) {
            if (vertex.id == id) {
                v = vertex;
                break;
            }
        }
        if (v == null)
            throw new Exception("Vertex does not exist");
        else
            return v;
    }

    /**
     * Adds an undirected edge between two vertices with no weight/cost
     * @param fromId id of the first vertex
     * @param toId id of the second vertex
     * @throws Exception throws exception if the ids are equal, or if either of the vertices do not exist
     */
    public void addEdge(int fromId, int toId) throws Exception{
        addEdge(fromId, toId, 0);
    }

    /**
     * Adds an undirected edge between two vertices with a given weight/cost
     * @param fromId id of the first vertex
     * @param toId id of the second vertex
     * @param weight the weight to be assigned to the edge
     * @throws Exception throws exception if the ids are equal, or if either of the vertices do not exist
     */
    public void addEdge(int fromId, int toId, double weight) throws Exception {
        Vertex<T> v =  null, u = null;
        if (fromId == toId) {
            throw new Exception("Cannot add edge to itself");
        }

        v = findVertex(fromId);
        u = findVertex(toId);

        u.addEdge(v, weight);
        v.addEdge(u, weight);
    }

    /**
     * Removes all the edges between two vertices
     * @param fromId id of the first vertex
     * @param toId id of the second vertex
     * @throws Exception when the given vertex/vertices does not exist
     */
    public void removeEdge(int fromId, int toId) throws Exception {
        Vertex<T> v =  null, u = null;

        v = findVertex(fromId);
        u = findVertex(toId);


        u.removeEdge(v);
        v.removeEdge(u);
    }

    /**
     * Removes all the edges to and from the given vertex
     * @param id id of the vertex
     */
    public void removeEdges(int id) throws Exception{
        Vertex<T> v = findVertex(id);

        this.forEach(vertex -> vertex.removeEdge(v));
        v.removeAllEdges();
    }

    /**
     * Prints the structure of the graph to the console
     */
    public void printGraph() {
        for (Vertex<T> v : this) {
            System.out.print(v.id + ":");
            for (Edges e: v.edges) {
                System.out.printf(" %d[%.2f]", e.destination.id, e.weight);
            }
            System.out.println();
        }
    }
}