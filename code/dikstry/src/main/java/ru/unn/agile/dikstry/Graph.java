package ru.unn.agile.dikstry;

import java.util.LinkedList;
import java.util.List;

public class Graph {
    private List<Edge> edges;


    public Graph(final double[][] matrix) {
        validateMatrix(matrix);

        List<Vertex> vertices = new LinkedList<>();
        List<Edge> edges = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            vertices.add(new Vertex(i));
        }

        for (int i = 0; i < vertices.size() - 1; i++) {
            Vertex vertex1 = vertices.get(i);
            Vertex vertex2 = vertices.get(i + 1);
            double weight = matrix[vertex1.getId()][vertex2.getId()];

            edges.add(new Edge(vertex1, vertex2, weight));
        }

        this.edges = edges;
    }

    private void validateMatrix(final double[][] matrix) {
        int numberOfVertex = matrix.length;
        for (int i = 0; i < matrix.length; i++) {
            if (numberOfVertex != matrix[i].length) {
                throw new IllegalArgumentException("matrix is not square");
            }
        }
    }


    public int getSizeOfEdges() {
        return edges.size();

    }
}
