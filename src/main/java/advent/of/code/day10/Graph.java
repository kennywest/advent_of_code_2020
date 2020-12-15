package advent.of.code.day10;

import java.util.LinkedList;

public class Graph {
    private long paths = 0;
    private LinkedList<Integer>[] adjList;

    Graph(Node startNode) {
        this(startNode.getLast().getValue());
        Node node = startNode;
        while (node.hasNext()) {
            for (Node next : node.getNextPossibleNodes()) {
                addEdge(node, next);
            }
            node = node.next();
        }
    }

    Graph(int vertices) {
        this.adjList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            this.adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(Node source, Node destination) {
        addEdge(source.getValue(), destination.getValue());
    }

    public void addEdge(int source, int destination) {
        this.adjList[source].addFirst(destination);
    }

    public void count(int start, int destination) {
        if (start == destination) {
            this.paths++;
        } else {
            for (int i = 0; i < this.adjList[start].size(); i++) {
                int ajdacentVertex = this.adjList[start].get(i);
                count(ajdacentVertex, destination);
            }
        }
    }

    public long getPaths() {
        return this.paths;
    }
}
