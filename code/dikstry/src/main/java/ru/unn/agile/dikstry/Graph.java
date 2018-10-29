package ru.unn.agile.dikstry;

import java.util.*;

public class Graph {
    private static int inf = Integer.MAX_VALUE;
    private List<Edge> edges;
    private int sizeOfVertex;


    public Graph(final int[][] matrix) {
        validateMatrix(matrix);

        List<Vertex> vertices = new LinkedList<>();
        List<Edge> edges = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            vertices.add(new Vertex(i));
        }
        sizeOfVertex = vertices.size();
        for (Vertex vertexI: vertices) {
            for (Vertex vertexJ : vertices) {
                int weight = matrix[vertexI.getId()][vertexJ.getId()];
                if (weight != 0) {
                    edges.add(new Edge(vertexI, vertexJ, weight));
                }
            }
        }

        this.edges = edges;
        validatenegativeVertex(edges);

    }

    private void validateMatrix(final int[][] matrix) {
        int numberOfVertex = matrix.length;
        for (int i = 0; i < matrix.length; i++) {
            if (numberOfVertex != matrix[i].length) {
                throw new IllegalArgumentException("matrix is not square");

            }
        }
    }

    private void validatenegativeVertex(final List<Edge> edges) {
        for (Edge edge: edges) {
            if (edge.getWeight() < 0) {
                throw new IllegalArgumentException("matrix have negative weight!");
            }
        }
    }

    public int getSizeOfEdges() {
        return edges.size();
    }

    public int dikstry(final Vertex startVertex, final Vertex endVertex) {

       List<Way> ways = new ArrayList<>(this.sizeOfVertex);
       for (int i = 0; i < this.sizeOfVertex; i++) {
           List<Vertex> vert = new ArrayList<>();
           Way waytmp = new Way(vert, inf);
           ways.add(waytmp);
       }
        ways.get(startVertex.getId()).addVertex(startVertex);
        ways.get(startVertex.getId()).addWeight(0);

        Set<Vertex> settledVertex = new HashSet<>();
        List<Vertex> unsettledVertex = new ArrayList<>();

        unsettledVertex.add(startVertex);

        while (!unsettledVertex.isEmpty()) {
            Vertex currentVertex = getLowestDistanceVertex(unsettledVertex, ways);
            unsettledVertex.remove(currentVertex);

            for (int i = 0; i < edges.size(); i++) {
                if (edges.get(i).getVertexLeft().getId() == currentVertex.getId()
                        && (!settledVertex.contains(edges.get(i).getVertexRight()))) {
                        calculateMinimumDistance(edges.get(i), ways);
                        if (!unsettledVertex.contains(edges.get(i).getVertexRight())) {
                            unsettledVertex.add(edges.get(i).getVertexRight());
                        }
                }
            }
            settledVertex.add(currentVertex);
        }

    return ways.get(endVertex.getId()).getWeight();
    }

    private static Vertex getLowestDistanceVertex(final List<Vertex> unsettledVertex,
                                                  final List<Way> ways) {
        int lowestDistance = inf;
        Vertex lowestDistanceVertex = null;
        for (int i = 0; i < unsettledVertex.size(); i++) {
          int idCurrentVertex = unsettledVertex.get(i).getId();
          if (ways.get(idCurrentVertex).getWeight() < lowestDistance) {
              lowestDistance = ways.get(idCurrentVertex).getWeight();
              lowestDistanceVertex = unsettledVertex.get(i);
          }
      }
        return lowestDistanceVertex;
    }
    private static void calculateMinimumDistance(final Edge edge, final List<Way> ways) {

        int sourceDistance = ways.get(edge.getVertexLeft().getId()).getWeight();
        int evaluationDistance = ways.get(edge.getVertexRight().getId()).getWeight();

        if (sourceDistance + edge.getWeight() < evaluationDistance) {
            ways.get(edge.getVertexRight().getId()).setWeight(sourceDistance + edge.getWeight());
            ways.get(edge.getVertexRight().getId()).addVertex(edge.getVertexLeft());
        }
    }


}
