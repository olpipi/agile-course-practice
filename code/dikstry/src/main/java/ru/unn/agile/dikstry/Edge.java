package ru.unn.agile.dikstry;

public class Edge {
    private double weight;
    private Vertex vertexLeft;
    private Vertex vertexRight;

    public Edge(final Vertex vertex1, final Vertex vertex2, final double weight) {
        this.vertexLeft = vertex1;
        this.vertexRight = vertex2;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(final double weight) {
        this.weight = weight;
    }

    public Vertex getVertexLeft() {
        return vertexLeft;
    }

    public Vertex getVertexRight() {
        return vertexRight;
    }
}
