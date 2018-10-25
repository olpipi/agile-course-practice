package ru.unn.agile.dikstry;


import org.junit.Test;

import static org.hamcrest.core.Is.is;
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

    @Test
    public void canInitGraph() {
        double[][] matrix = {
                {
                    0, 2
                },
                {
                    3, 0
                }
        };
        Graph graph = new Graph(matrix);

        assertEquals(1, graph.getSizeOfEdges());
    }

    @Test
    public void canInitGraphWithThreeEdges() {
        double[][] matrix = {
                {
                    0, 2, 5
                },
                {
                    0, 0, 1
                },
                {
                    0, 2, 0
                }
        };
        Graph graph = new Graph(matrix);

        assertEquals(2, graph.getSizeOfEdges());
    }

    @Test(expected = IllegalArgumentException.class)
    public void canInvalidGraphInitiated() {
        double[][] matrix = {
                {
                    0, 2
                },
                {
                    0, 0, 1
                },
                {
                    0, 2, 0
                }
        };
        Graph graph = new Graph(matrix);

        assertEquals(2, graph.getSizeOfEdges());
    }

    @Test
    public void canInvalidGraphInitiatedMessage() {
        double[][] matrix = {
                {
                    0, 2
                },
                {
                    0, 0, 1
                },
                {
                    0, 2, 0
                }
        };
        try {
            Graph graph = new Graph(matrix);
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("matrix is not square"));
        }
    }

}
