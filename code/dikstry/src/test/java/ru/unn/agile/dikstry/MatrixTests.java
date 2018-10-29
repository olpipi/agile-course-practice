package ru.unn.agile.dikstry;


import org.junit.Test;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MatrixTests {
    private static double delta = 0.1;

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
        int[][] matrix = {
                {
                    0, 2
                },
                {
                    3, 0
                }
        };
        Graph graph = new Graph(matrix);

        assertEquals(2, graph.getSizeOfEdges());
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

        assertEquals(4, graph.getSizeOfEdges());
    }

    @Test(expected = IllegalArgumentException.class)
    public void canInvalidGraphInitiated() {
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
        Graph graph = new Graph(matrix);

        assertEquals(2, graph.getSizeOfEdges());
    }

    @Test
    public void canInvalidGraphInitiatedMessage() {
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
            assertThat(e.getMessage(), is("matrix is not square"));
        }
    }

    @Test
    public void isGraphDontHaveNegativeWeight() {
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
            assertThat(e.getMessage(), is("matrix have negative weight!"));
        }
    }

    @Test
    public void isGraphEmpty() {
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
            assertThat(e.getMessage(), is("matrix have negative weight!"));
        }
    }

    @Test
    public void isCalculateDistanceToStartVertex() {
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

        assertEquals(0, graph.dikstry(vertexOfStart, vertexOfEnd));
    }

    @Test
    public void isCalculateDistanceOnStartToFirstVertex() {
        int[][] matrix = {
                {
                        0, 4, 2
                },
                {
                        1, 0, 0
                },
                {
                        3, 0, 0
                }
        };
        Graph graph = new Graph(matrix);
        Vertex vertexOfStart = new Vertex(0);
        Vertex vertexOfEnd = new Vertex(1);


        assertEquals(4, graph.dikstry(vertexOfStart, vertexOfEnd));
    }

    @Test
    public void isLowestDistancewithOneVertexInDistance() {
        int[][] matrix = {
                {
                        0, 4, 0
                },
                {
                        1, 0, 0
                },
                {
                        1, 0, 0
                }
        };
        Graph graph = new Graph(matrix);
        Vertex vertexOfStart = new Vertex(0);
        Vertex vertexOfEnd = new Vertex(1);
        assertEquals(4, graph.dikstry(vertexOfStart, vertexOfEnd));
    }

    @Test
    public void isLowestDistancewithTwoVertexInDistance() {
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
        assertEquals(3, graph.dikstry(vertexOfStart, vertexOfEnd));
    }

    @Test
    public void isLowestDistanceWithThreeVertexInDistance() {
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
        assertEquals(2, graph.dikstry(vertexOfStart, vertexOfEnd));
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
        assertEquals(5, graph.dikstry(vertexOfStart, vertexOfEnd));
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
        assertEquals(2, graph.dikstry(vertexOfStart, vertexOfEnd));
    }

}
