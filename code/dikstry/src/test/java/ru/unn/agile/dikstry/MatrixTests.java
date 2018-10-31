package ru.unn.agile.dikstry;


import org.junit.Test;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MatrixTests {
    private static final double DELTA = 0.01;


    @Test
    public void canInitVertex() {
        Vertex vertex = new Vertex(1);

        int idVertex = vertex.getId();

        assertEquals(1, idVertex);
    }

    @Test
    public void canInitVertexWithOtherId() {
        Vertex vertex = new Vertex(2);

        int idVertex = vertex.getId();

        assertEquals(2, idVertex);
    }

    @Test
    public void canInitEdgeWithOtherId() {
        Vertex vertex1 = new Vertex(1);
        Vertex vertex2 = new Vertex(2);

        Edge edge = new Edge(vertex1, vertex2, 1);

        assertEquals(1, edge.getWeight(), DELTA);
    }

    @Test
    public void canEdgeGetVertexLeft() {
        Vertex vertex1 = new Vertex(1);
        Vertex vertex2 = new Vertex(2);
        Edge edge = new Edge(vertex1, vertex2, 1);

        int vertexId = edge.getVertexLeft().getId();

        assertEquals(1, vertexId);
    }

    @Test
    public void canEdgeGetVertexRight() {
        Vertex vertex1 = new Vertex(1);
        Vertex vertex2 = new Vertex(2);
        Edge edge = new Edge(vertex1, vertex2, 1);

        int idRightVertex = edge.getVertexRight().getId();

        assertEquals(2, idRightVertex, DELTA);
    }

    @Test
    public void canInitGraph() {
        int[][] matrix = {
                {
                        0, 2
                },
                {
                        3, 0
                }
        };
        Graph graph = new Graph(matrix);

        int edgesSize = graph.getEdgesSize();

        assertEquals(2, edgesSize);
    }

    @Test
    public void canInitGraphWithThreeEdges() {
        int[][] matrix = {
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

        int edgesSize = graph.getEdgesSize();

        assertEquals(4, edgesSize);
    }

    @Test
    public void canGraphValidateMatrix() {
        int[][] matrix = {
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
            new Graph(matrix);
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("Matrix must be square"));
        }
    }

    @Test
    public void isGraphCheckNegativeWeight() {
        int[][] matrix = {
                {
                        0, 4, -2
                },
                {
                        -1, 0, 1
                },
                {
                        0, 1, 0
                }
        };


        try {
            new Graph(matrix);
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("Matrix can't have negative weight"));
        }
    }

    @Test
    public void shouldReturnErrorIfGraphIsEmpty() {
        int[][] matrix = {
                {
                        0, 0, 0
                },
                {
                        0, 0, 0
                },
                {
                        0, 0, 0
                }
        };
        try {
            new Graph(matrix);
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("Graph don't have any edges"));
        }
    }

    @Test
    public void isDistanceToStartingVertexCalculatedCorrectly() {
        int[][] matrix = {
                {
                        0, 2, 0
                },
                {
                        0, 0, 0
                },
                {
                        1, 0, 0
                }
        };
        Graph graph = new Graph(matrix);
        Vertex vertexOfStart = new Vertex(0);
        Vertex vertexOfEnd = new Vertex(0);

        int minDistance = graph.dijkstra(vertexOfStart, vertexOfEnd);

        assertEquals(0, minDistance);
    }

    @Test
    public void isDistanceOnStartToFirstVertexCalculatesCorrectly() {
        int[][] matrix = {
                {
                        0, 7, 9
                },
                {
                        10, 0, 0
                },
                {
                        11, 0, 0
                }
        };
        Graph graph = new Graph(matrix);
        Vertex vertexOfStart = new Vertex(0);
        Vertex vertexOfEnd = new Vertex(1);

        int minDistance = graph.dijkstra(vertexOfStart, vertexOfEnd);

        assertEquals(7, minDistance);
    }

    @Test
    public void isLowestDistanceWithOneVertexInDistance() {
        int[][] matrix = {
                {
                        0, 1, 3
                },
                {
                        3, 0, 10
                },
                {
                        9, 0, 10
                }
        };
        Graph graph = new Graph(matrix);
        Vertex vertexOfStart = new Vertex(0);
        Vertex vertexOfEnd = new Vertex(2);

        int minDistance = graph.dijkstra(vertexOfStart, vertexOfEnd);

        assertEquals(3, minDistance);
    }

    @Test
    public void isLowestDistanceWithTwoVertexInWay() {
        int[][] matrix = {
                {
                        0, 4, 2
                },
                {
                        1, 0, 0
                },
                {
                        0, 1, 0
                }
        };
        Graph graph = new Graph(matrix);
        Vertex vertexOfStart = new Vertex(0);
        Vertex vertexOfEnd = new Vertex(1);

        int minDistance = graph.dijkstra(vertexOfStart, vertexOfEnd);

        assertEquals(3, minDistance);
    }

    @Test
    public void isLowestDistanceWithThreeVertexInWay() {
        int[][] matrix = {
                {
                        0, 1, 4
                },
                {
                        1, 0, 1
                },
                {
                        0, 1, 0
                }
        };
        Graph graph = new Graph(matrix);
        Vertex vertexOfStart = new Vertex(0);
        Vertex vertexOfEnd = new Vertex(2);

        int minDistance = graph.dijkstra(vertexOfStart, vertexOfEnd);

        assertEquals(2, minDistance);
    }

    @Test
    public void isLowestDistanceThenStartedVertexNotZero() {
        int[][] matrix = {
                {
                        0, 1, 4
                },
                {
                        1, 0, 10
                },
                {
                        0, 1, 0
                }
        };
        Graph graph = new Graph(matrix);
        Vertex vertexOfStart = new Vertex(1);
        Vertex vertexOfEnd = new Vertex(2);

        int minDistance = graph.dijkstra(vertexOfStart, vertexOfEnd);

        assertEquals(5, minDistance);
    }

    @Test
    public void isRightDistanceInGraphWithForeVertex() {
        int[][] matrix = {
                {
                        0, 1, 4, 1
                },
                {
                        1, 0, 10, 0
                },
                {
                        0, 1, 0, 6
                },
                {
                        2, 1, 0, 13
                }
        };
        Graph graph = new Graph(matrix);
        Vertex vertexOfStart = new Vertex(1);
        Vertex vertexOfEnd = new Vertex(3);
        assertEquals(2, graph.dijkstra(vertexOfStart, vertexOfEnd));
    }

}
