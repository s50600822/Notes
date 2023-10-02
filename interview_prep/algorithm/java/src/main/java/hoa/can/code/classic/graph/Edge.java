package hoa.can.code.classic.graph;

public class Edge {
    public final int f;
    public final int t;

    public Edge(int f, int t) {
        this.f = f;
        this.t = t;
    }

    public Edge rev(){
        return new Edge(t,f);
    }

    @Override
    public String toString() {
        return String.format("[%d --> %d]", f, t);
    }
}
