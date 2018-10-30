package ru.unn.agile.dikstry;

import java.util.*;

public class Graph {
    private static final int INF = Integer.MAX_VALUE;
    private List<Edge> edges;
    private int vertexesCount;
    private List<Way> ways;

    public Graph(final int[][] matrix) {
        validateMatrix(matrix);
        List<Vertex> vertices = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            vertices.add(new Vertex(i));
        }
        vertexesCount = vertices.size();
        ways = new ArrayList<>(vertexesCount);
        this.edges = initEdges(matrix, vertices);
    }

    private List<Edge> initEdges(final int[][] matrix, final List<Vertex> vertices) {
        List<Edge> edges = new LinkedList<>();
        for (Vertex vertexI : vertices) {
            for (Vertex vertexJ : vertices) {
                int weight = matrix[vertexI.getId()][vertexJ.getId()];
                if (weight > 0) {
                    edges.add(new Edge(vertexI, vertexJ, weight));
                }
            }
        }
        return edges;
    }

    private void validateMatrix(final int[][] matrix) {
        int numberOfVertex = matrix.length;
        for (int i = 0; i < matrix.length; i++) {
            if (numberOfVertex != matrix[i].length) {
                throw new IllegalArgumentException("matrix is not square");
            }
        }
    }

    public int getEdgesSize() {
        return edges.size();
    }

    public int dijkstra(final Vertex startVertex, final Vertex endVertex) {
        for (int i = 0; i < vertexesCount; i++) {
            List<Vertex> vert = new ArrayList<>();
            Way waytmp = new Way(vert, INF);
            ways.add(waytmp);
        }
        int startId = startVertex.getId();
        ways.get(startId).addVertex(startVertex);
        ways.get(startId).addWeight(0);
        Set<Vertex> settledVertex = new HashSet<>();
        List<Vertex> unsettledVertex = new ArrayList<>();
        unsettledVertex.add(startVertex);

        while (!unsettledVertex.isEmpty()) {
            Vertex currentVertex = getLowestDistanceVertex(unsettledVertex, ways);
            unsettledVertex.remove(currentVertex);
            for (int i = 0; i < edges.size(); i++) {
                int idCurrentVertex = currentVertex.getId();
                checkCondition(edges.get(i), idCurrentVertex, settledVertex, unsettledVertex);
            }
            settledVertex.add(currentVertex);
        }
        return ways.get(endVertex.getId()).getWeight();
    }

    private void checkCondition(final Edge edge, final int idCurrentVertex,
                                final Set<Vertex> settledVertex, final List<Vertex> unsettlVertex) {
        if ((edge.getIdLeftVertex() == idCurrentVertex)
                && (!settledVertex.contains(edge.getVertexRight()))) {
            calculateMinimumDistance(edge, ways);
            if (!unsettlVertex.contains(edge.getVertexRight())) {
                unsettlVertex.add(edge.getVertexRight());
            }
        }
    }

    private Vertex getLowestDistanceVertex(final List<Vertex> unsettledVertex,
                                           final List<Way> ways) {
        int lowestDistance = INF;
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

    private void calculateMinimumDistance(final Edge edge, final List<Way> ways) {
        int idLeftVertexOfEdge = edge.getIdLeftVertex();
        int idRightVertexOfEdge = edge.getIdRighttVertex();
        int sourceDistance = ways.get(idLeftVertexOfEdge).getWeight();
        int evaluationDistance = ways.get(idRightVertexOfEdge).getWeight();
        int actualWeight = sourceDistance + edge.getWeight();
        if (actualWeight < evaluationDistance) {
            ways.get(idRightVertexOfEdge).setWeight(actualWeight);
            ways.get(idRightVertexOfEdge).addVertex(edge.getVertexLeft());
        }
    }
}
