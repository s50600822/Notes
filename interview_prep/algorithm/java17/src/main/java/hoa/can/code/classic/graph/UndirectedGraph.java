package hoa.can.code.classic.graph;

import java.util.List;

public class UndirectedGraph<V> extends Graph<V, Edge> {
    public UndirectedGraph(List<V> vertices) {
        super(vertices);
    }

    public void add(Edge edge) {
        Edge revEdge = edge.rev();
        edges.get(edge.f).add(edge);
        edges.get(edge.t).add(revEdge);
    }

    public void add(int f, int t) {
        add(new Edge(f, t));
    }

    public void add(V f, V t) {
        add(
                new Edge(idx(f), idx(t))
        );
    }
}
