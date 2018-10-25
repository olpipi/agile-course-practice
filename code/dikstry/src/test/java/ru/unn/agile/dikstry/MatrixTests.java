package ru.unn.agile.dikstry;

import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTests {
    private static double delta = 0.01;

    @Test
    public void canInitVertex() {
        Vertex vertex = new Vertex(1);
        assertEquals(1, vertex.getId());
    }

    @Test
    public void canInitVertexWithOtherId() {
        Vertex vertex = new Vertex(2);
        assertEquals(2, vertex.getId());
    }

    @Test
    public void canInitEdgeIthOtherId() {
        Vertex vertex1 = new Vertex(1);
        Vertex vertex2 = new Vertex(2);
        Edge edge = new Edge(vertex1, vertex2, 1);
        assertEquals(1, edge.getWeight(), delta);
    }

    @Test
    public void canInitEdgeGetVertexLeft() {
        Vertex vertex1 = new Vertex(1);
        Vertex vertex2 = new Vertex(2);
        Edge edge = new Edge(vertex1, vertex2, 1);
        assertEquals(1, edge.getVertexLeft().getId());
    }

    @Test
    public void canInitEdgeGetVertexRight() {
        Vertex vertex1 = new Vertex(1);
        Vertex vertex2 = new Vertex(2);
        Edge edge = new Edge(vertex1, vertex2, 1);
        assertEquals(2, edge.getVertexRight().getId(), delta);
    }
}
