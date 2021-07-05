/**
 * Each node in the edge list for a vertex hold the weight of the
 * edge and the destination vertex
 */

public class Edges<T> {
    double weight;
    Vertex<T> destination;

    public Edges(double weight, Vertex destination) {
        this.weight = weight;
        this.destination = destination;
    }
}
