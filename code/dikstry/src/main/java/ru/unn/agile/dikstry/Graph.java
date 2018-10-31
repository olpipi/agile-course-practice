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
        edges = initEdges(matrix, vertices);
    }

    private List<Edge> initEdges(final int[][] matrix, final List<Vertex> vertices) {
        List<Edge> edges = new LinkedList<>();
        for (Vertex vertexI : vertices) {
            for (Vertex vertexJ : vertices) {
                int weight = matrix[vertexI.getId()][vertexJ.getId()];
                if (weight > 0) {
                    edges.add(new Edge(vertexI, vertexJ, weight));
                } else if (weight < 0) {
                    throw new IllegalArgumentException("Matrix can't have negative weight");
                }
            }
        }
        if (edges.isEmpty()) {
            throw new IllegalArgumentException("Graph don't have any edges");
        } else {
            return edges;
        }
    }

    private void validateMatrix(final int[][] matrix) {
        int numberOfVertex = matrix.length;
        for (int i = 0; i < matrix.length; i++) {
            if (numberOfVertex != matrix[i].length) {
                throw new IllegalArgumentException("Matrix must be square");
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
                int currentVertexId = currentVertex.getId();
                checkCondition(edges.get(i), currentVertexId, settledVertex, unsettledVertex);
            }
            settledVertex.add(currentVertex);
        }
        return ways.get(endVertex.getId()).getWeight();
    }

    private void checkCondition(final Edge edge, final int currentVertexId,
                                final Set<Vertex> settledVertex, final List<Vertex> unsetlVertex) {
        if ((edge.getIdLeftVertex() == currentVertexId)
                && (!settledVertex.contains(edge.getVertexRight()))) {
            calculateMinimumDistance(edge, ways);
            if (!unsetlVertex.contains(edge.getVertexRight())) {
                unsetlVertex.add(edge.getVertexRight());
            }
        }
    }

    private Vertex getLowestDistanceVertex(final List<Vertex> unsettledVertex,
                                           final List<Way> ways) {
        int lowestDistance = INF;
        Vertex lowestDistanceVertex = null;
        for (int i = 0; i < unsettledVertex.size(); i++) {
            int currentVertexId = unsettledVertex.get(i).getId();
            if (ways.get(currentVertexId).getWeight() < lowestDistance) {
                lowestDistance = ways.get(currentVertexId).getWeight();
                lowestDistanceVertex = unsettledVertex.get(i);
            }
        }
        return lowestDistanceVertex;
    }

    private void calculateMinimumDistance(final Edge edge, final List<Way> ways) {
        int leftVertexOfEdgeId = edge.getIdLeftVertex();
        int rightVertexOfEdgeId = edge.getIdRightVertex();
        ways.get(leftVertexOfEdgeId).upDateWay(edge, ways.get(rightVertexOfEdgeId));

    }
}
