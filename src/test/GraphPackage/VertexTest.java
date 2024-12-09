package GraphPackage;

import org.junit.jupiter.api.Test;
import java.util.Iterator;
import static org.junit.jupiter.api.Assertions.*;

class VertexTest {

    @Test
    void getLabel() {
        Vertex<String> vertex = new Vertex<>("A");
        assertEquals("A", vertex.getLabel());
    }

    @Test
    void hasPredecessor() {
        Vertex<String> vertex = new Vertex<>("A");
        assertFalse(vertex.hasPredecessor());
    }

    @Test
    void setPredecessor() {
        Vertex<String> vertexA = new Vertex<>("A");
        Vertex<String> vertexB = new Vertex<>("B");
        vertexA.setPredecessor(vertexB);
        assertTrue(vertexA.hasPredecessor());
    }

    @Test
    void getPredecessor() {
        Vertex<String> vertexA = new Vertex<>("A");
        Vertex<String> vertexB = new Vertex<>("B");
        vertexA.setPredecessor(vertexB);
        assertEquals(vertexB, vertexA.getPredecessor());
    }

    @Test
    void visit() {
        Vertex<String> vertex = new Vertex<>("A");
        vertex.visit();
        assertTrue(vertex.isVisited());
    }

    @Test
    void unvisit() {
        Vertex<String> vertex = new Vertex<>("A");
        vertex.visit();
        vertex.unvisit();
        assertFalse(vertex.isVisited());
    }

    @Test
    void isVisited() {
        Vertex<String> vertex = new Vertex<>("A");
        assertFalse(vertex.isVisited());
        vertex.visit();
        assertTrue(vertex.isVisited());
    }

    @Test
    void getCost() {
        Vertex<String> vertex = new Vertex<>("A");
        assertEquals(0, vertex.getCost());
    }

    @Test
    void setCost() {
        Vertex<String> vertex = new Vertex<>("A");
        vertex.setCost(5.0);
        assertEquals(5.0, vertex.getCost());
    }

    @Test
    void testToString() {
        Vertex<String> vertex = new Vertex<>("A");
        assertEquals("A", vertex.toString());
    }

    @Test
    void getWeightIterator() {
        Vertex<String> vertexA = new Vertex<>("A");
        Vertex<String> vertexB = new Vertex<>("B");
        vertexA.connect(vertexB, 2.5);

        Iterator<Double> weightIterator = vertexA.getWeightIterator();
        assertTrue(weightIterator.hasNext());
        assertEquals(2.5, weightIterator.next());
    }

    @Test
    void connect() {
        Vertex<String> vertexA = new Vertex<>("A");
        Vertex<String> vertexB = new Vertex<>("B");
        assertTrue(vertexA.connect(vertexB, 1.0));
        assertFalse(vertexA.connect(vertexB, 1.0)); // Duplicate edge
    }

    @Test
    void testConnect() {
        Vertex<String> vertexA = new Vertex<>("A");
        Vertex<String> vertexB = new Vertex<>("B");
        assertTrue(vertexA.connect(vertexB));
    }

    @Test
    void getNeighborIterator() {
        Vertex<String> vertexA = new Vertex<>("A");
        Vertex<String> vertexB = new Vertex<>("B");
        vertexA.connect(vertexB);

        Iterator<VertexInterface<String>> neighborIterator = vertexA.getNeighborIterator();
        assertTrue(neighborIterator.hasNext());
        assertEquals(vertexB, neighborIterator.next());
    }

    @Test
    void hasNeighbor() {
        Vertex<String> vertex = new Vertex<>("A");
        assertFalse(vertex.hasNeighbor());

        Vertex<String> neighbor = new Vertex<>("B");
        vertex.connect(neighbor);
        assertTrue(vertex.hasNeighbor());
    }

    @Test
    void getUnvisitedNeighbor() {
        Vertex<String> vertexA = new Vertex<>("A");
        Vertex<String> vertexB = new Vertex<>("B");
        vertexA.connect(vertexB);

        assertEquals(vertexB, vertexA.getUnvisitedNeighbor());
        vertexB.visit();
        assertNull(vertexA.getUnvisitedNeighbor());
    }

    @Test
    void testEquals() {
        Vertex<String> vertexA = new Vertex<>("A");
        Vertex<String> vertexB = new Vertex<>("B");
        Vertex<String> vertexA2 = new Vertex<>("A");

        assertEquals(vertexA, vertexA2);
        assertNotEquals(vertexA, vertexB);
    }

    @Test
    void display() {
        Vertex<String> vertexA = new Vertex<>("A");
        Vertex<String> vertexB = new Vertex<>("B");
        vertexA.connect(vertexB, 2.5);

        vertexA.display(); // Verify visually in console: should display "A B 2.5"
    }
}
