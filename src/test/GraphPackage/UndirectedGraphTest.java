package GraphPackage;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UndirectedGraphTest {

    @Test
    void addEdge() {
        UndirectedGraph<String> graph = new UndirectedGraph<>();
        graph.addVertex("A");
        graph.addVertex("B");

        assertTrue(graph.addEdge("A", "B"));
        assertTrue(graph.hasEdge("A", "B"));
        assertTrue(graph.hasEdge("B", "A"));
    }

    @Test
    void testAddEdge() {
        UndirectedGraph<String> graph = new UndirectedGraph<>();
        graph.addVertex("A");
        graph.addVertex("B");

        assertTrue(graph.addEdge("A", "B", 2.5));
        assertTrue(graph.hasEdge("A", "B"));
        assertTrue(graph.hasEdge("B", "A"));
    }

    @Test
    void getNumberOfEdges() {
        UndirectedGraph<String> graph = new UndirectedGraph<>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");

        graph.addEdge("A", "B");
        graph.addEdge("B", "C");

        assertEquals(2, graph.getNumberOfEdges()); // Each edge is only counted once
    }

    @Test
    void getTopologicalOrder() {
        UndirectedGraph<String> graph = new UndirectedGraph<>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addEdge("A", "B");

        Exception exception = assertThrows(UnsupportedOperationException.class, graph::getTopologicalOrder);
        assertEquals("Topological sort is illegal in an undirected graph.", exception.getMessage());
    }
}
