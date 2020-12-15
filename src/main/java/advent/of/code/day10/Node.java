package advent.of.code.day10;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node {
    private final int value;
    private final Node previous;
    private Node next;

    public Node(int value, Node previous) {
        this.value = value;
        this.previous = previous;
    }

    Node addNext(Integer value) {
        this.next = new Node(value, this);
        return this.next;
    }

    boolean hasNext() {
        return this.next != null;
    }

    Node next() {
        return this.next;
    }

    Node getFirst() {
        Node node = this;
        while (node.previous != null) {
            node = node.previous;
        }
        return node;
    }

    Node getLast() {
        Node node = this;
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }

    public int getValue() {
        return this.value;
    }

    public List<Node> getNextPossibleNodes() {
        List<Node> nextPossibleNodes = new ArrayList<>();
        Node nextPossibleNode = this.next;
        while (nextPossibleNode != null && nextPossibleNode.value - this.value <= 3) {
            nextPossibleNodes.add(nextPossibleNode);
            nextPossibleNode = nextPossibleNode.next;
        }

        return nextPossibleNodes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Node node = (Node) o;
        return this.value == node.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.value);
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
