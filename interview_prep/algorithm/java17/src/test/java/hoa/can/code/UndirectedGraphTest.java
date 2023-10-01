package hoa.can.code;

import hoa.can.code.classic.graph.Search;
import hoa.can.code.classic.graph.UndirectedGraph;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UndirectedGraphTest {
    @Test
    @DisplayName("UndirectedGraphTest")
    public void test1() {
        UndirectedGraph<String> g = cities();
        Search.Node<String> bfsResult = Search.bfs(
                "Seattle",
                v -> v.equals("Chicago"),
                g::neighbor);
        List<String> path = Search.nodeToPath(bfsResult);
        assertEquals(List.of("Seattle","Chicago"), path);

    }

    @Test
    @DisplayName("UndirectedGraphTest2")
    public void test2() {
        UndirectedGraph<String> g = cities();
        Search.Node<String> bfsResult = Search.bfs(
                "Seattle",
                v -> v.equals("Riverside"),
                g::neighbor);
        List<String> path = Search.nodeToPath(bfsResult);
        assertEquals("Seattle", path.get(0));
        assertEquals("Riverside", path.get(path.size()-1));

    }

    @Test
    @DisplayName("UndirectedGraphTest3")
    public void test3() {
        UndirectedGraph<String> g = cities();
        Search.Node<String> bfsResult = Search.bfs(
                "Chicago",
                v -> v.equals("Seattle"),
                g::neighbor);
        List<String> path = Search.nodeToPath(bfsResult);
        assertEquals(List.of("Chicago","Seattle"), path);

    }

    @Test
    @DisplayName("UndirectedGraphTest4")
    public void test4() {
        UndirectedGraph<String> g = cities();
        System.out.println(g);
        Search.Node<String> bfsResult = Search.bfs(
                "Boston",
                v -> v.equals("Miami"),
                g::neighbor);
        List<String> path = Search.nodeToPath(bfsResult);
    }

    private UndirectedGraph<String> cities(){
        UndirectedGraph<String> cityGraph = new UndirectedGraph<>(
                List.of("Seattle", "San Francisco", "Los Angeles", "Riverside", "Phoenix", "Chicago", "Boston",
                        "New York", "Atlanta", "Miami", "Dallas", "Houston", "Detroit", "Philadelphia", "Washington"));

        cityGraph.add("Seattle", "Chicago");
        cityGraph.add("Seattle", "San Francisco");
        cityGraph.add("San Francisco", "Riverside");
        cityGraph.add("San Francisco", "Los Angeles");
        cityGraph.add("Los Angeles", "Riverside");
        cityGraph.add("Los Angeles", "Phoenix");
        cityGraph.add("Riverside", "Phoenix");
        cityGraph.add("Riverside", "Chicago");
        cityGraph.add("Phoenix", "Dallas");
        cityGraph.add("Phoenix", "Houston");
        cityGraph.add("Dallas", "Chicago");
        cityGraph.add("Dallas", "Atlanta");
        cityGraph.add("Dallas", "Houston");
        cityGraph.add("Houston", "Atlanta");
        cityGraph.add("Houston", "Miami");
        cityGraph.add("Atlanta", "Chicago");
        cityGraph.add("Atlanta", "Washington");
        cityGraph.add("Atlanta", "Miami");
        cityGraph.add("Miami", "Washington");
        cityGraph.add("Chicago", "Detroit");
        cityGraph.add("Detroit", "Boston");
        cityGraph.add("Detroit", "Washington");
        cityGraph.add("Detroit", "New York");
        cityGraph.add("Boston", "New York");
        cityGraph.add("New York", "Philadelphia");
        cityGraph.add("Philadelphia", "Washington");
        return cityGraph;
    }
}
