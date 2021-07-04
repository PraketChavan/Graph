/**
 * Class representing a directed
 * @param <T> data that the graph contains
 */
public class DirectedGraph<T> extends Graph<T>{
    @Override
    public void addEdge(int fromId, int toId) throws Exception {
        this.addEdge(fromId, toId, 0);
    }

    @Override
    public void addEdge(int fromId, int toId, double weight) throws Exception {
        Vertex<T> v = findVertex(fromId);
        Vertex<T> u = findVertex(toId);

        v.addEdge(u, weight);
    }

}
