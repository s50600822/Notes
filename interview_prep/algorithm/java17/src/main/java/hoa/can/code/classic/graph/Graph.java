package hoa.can.code.classic.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Graph<V, E extends Edge> {
    private List<V> vertices = new ArrayList<>();
    protected List<List<E>> edges = new ArrayList<>();

    public Graph(){}

    public Graph(List<V> vertices){
        this.vertices.addAll(vertices);
        vertices.forEach(whatever -> edges.add(new ArrayList<>()));
    }

    public int edgeCount(){
        return edges.stream().mapToInt(List::size).sum();
    }

    public int add(V vertex){
        vertices.add(vertex);
        edges.add(new ArrayList<>());
        return vertices.size()-1;
    }

    public List<V> neighbor(int idx){
        return edges.get(idx).stream()
                .map(e -> vertices.get(e.t))
                .collect(Collectors.toList());
    }

    public List<V> neighbor(V v){
        return neighbor(vertices.indexOf(v));
    }

    public int idx(V v){
        return vertices.indexOf(v);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<vertices.size(); i++){
            sb.append(vertices.get(i));
            sb.append(">");
            sb.append(Arrays.toString(neighbor(i).toArray()));
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
