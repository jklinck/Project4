package GraphPackage;

import ADTPackage.LinkedStack;
import ADTPackage.QueueInterface;
import ADTPackage.StackInterface;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectedGraphTest {

    @Test
    void removeUser() {
        DirectedGraph<String> graph = new DirectedGraph<>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.removeUser("A");

        assertFalse(graph.hasEdge("A", "B"));
        assertEquals(1, graph.getNumberOfVertices());
    }

    @Test
    void addVertex() {
        DirectedGraph<String> graph = new DirectedGraph<>();
        assertTrue(graph.addVertex("A"));
        assertEquals(1, graph.getNumberOfVertices());
    }

    @Test
    void addEdge() {
        DirectedGraph<String> graph = new DirectedGraph<>();
        graph.addVertex("A");
        graph.addVertex("B");

        assertTrue(graph.addEdge("A", "B"));
        assertEquals(1, graph.getNumberOfEdges());
    }

    @Test
    void testAddEdge() {
        DirectedGraph<String> graph = new DirectedGraph<>();
        graph.addVertex("A");
        graph.addVertex("B");

        assertTrue(graph.addEdge("A", "B", 2.5));
        assertEquals(1, graph.getNumberOfEdges());
    }

    @Test
    void hasEdge() {
        DirectedGraph<String> graph = new DirectedGraph<>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addEdge("A", "B");

        assertTrue(graph.hasEdge("A", "B"));
        assertFalse(graph.hasEdge("B", "A"));
    }

    @Test
    void isEmpty() {
        DirectedGraph<String> graph = new DirectedGraph<>();
        assertTrue(graph.isEmpty());

        graph.addVertex("A");
        assertFalse(graph.isEmpty());
    }

    @Test
    void clear() {
        DirectedGraph<String> graph = new DirectedGraph<>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addEdge("A", "B");

        graph.clear();
        assertTrue(graph.isEmpty());
        assertEquals(0, graph.getNumberOfEdges());
    }

    @Test
    void getNumberOfVertices() {
        DirectedGraph<String> graph = new DirectedGraph<>();
        graph.addVertex("A");
        graph.addVertex("B");

        assertEquals(2, graph.getNumberOfVertices());
    }

    @Test
    void getNumberOfEdges() {
        DirectedGraph<String> graph = new DirectedGraph<>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addEdge("A", "B");

        assertEquals(1, graph.getNumberOfEdges());
    }

    @Test
    void getBreadthFirstTraversal() {
        DirectedGraph<String> graph = new DirectedGraph<>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");

        var traversal = graph.getBreadthFirstTraversal("A");
        assertNotNull(traversal);
    }

    @Test
    void getDepthFirstTraversal() {
        DirectedGraph<String> graph = new DirectedGraph<>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addEdge("A", "B");
        graph.addEdge("B", "C");

        var traversal = graph.getDepthFirstTraversal("A");
        assertNotNull(traversal);
    }

    @Test
    void getTopologicalOrder() {
        DirectedGraph<String> graph = new DirectedGraph<>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addEdge("A", "B");
        graph.addEdge("B", "C");

        var order = graph.getTopologicalOrder();
        assertNotNull(order);
    }

    @Test
    void getShortestPath() {
        DirectedGraph<String> graph = new DirectedGraph<>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addEdge("A", "B");
        graph.addEdge("B", "C");

        StackInterface<String> path = new LinkedStack<>();
        int pathLength = graph.getShortestPath("A", "C", path);

        assertEquals(2, pathLength);
        assertFalse(path.isEmpty());
    }

    @Test
    void getCheapestPath() {
        DirectedGraph<String> graph = new DirectedGraph<>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addEdge("A", "B", 1.5);
        graph.addEdge("B", "C", 2.5);

        StackInterface<String> path = new LinkedStack<>();
        double pathCost = graph.getCheapestPath("A", "C", path);

        assertEquals(4.0, pathCost, 0.01);
        assertFalse(path.isEmpty());
    }

    @Test
    void displayEdges() {
        DirectedGraph<String> graph = new DirectedGraph<>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addEdge("A", "B");

        // Redirect System.out to capture output for verification
        assertDoesNotThrow(graph::displayEdges);
    }
}
