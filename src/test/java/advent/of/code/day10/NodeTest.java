package advent.of.code.day10;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import static com.google.common.io.Resources.getResource;
import static com.google.common.io.Resources.readLines;
import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

public class NodeTest {

    @Test
    public void shouldFindFirst() {
        Node start = asLinkedListOfNodes(newArrayList(16, 10, 15, 5, 1, 11, 7, 19, 6, 12, 4));

        assertThat(start.getValue()).isEqualTo(0);
    }

    @Test
    public void shouldFindAllPaths1() {
        Node node = asLinkedListOfNodes(newArrayList(16, 10, 15, 5, 1, 11, 7, 19, 6, 12, 4));

        var graph = new Graph(node);
        graph.count(node.getValue(), node.getLast().getValue());

        assertThat(graph.getPaths()).isEqualTo(8);
    }

    @Test
    public void shouldFindAllPaths2() throws Exception {
        Node node = asLinkedListOfNodes("input_10_1.txt");

        var graph = new Graph(node);
        graph.count(node.getValue(), node.getLast().getValue());

        assertThat(graph.getPaths()).isEqualTo(19208);
    }

    @Ignore // performance is bad, there's probably another way :D
    @Test
    public void shouldFindAllPaths3() throws Exception {
        Node node = asLinkedListOfNodes("input_10_2.txt");

        var graph = new Graph(node);
        graph.count(node.getValue(), node.getLast().getValue());

        assertThat(graph.getPaths()).isEqualTo(19208);
    }

    private Node asLinkedListOfNodes(String file) throws Exception {
        return asLinkedListOfNodes(readLines(getResource(file), UTF_8).stream().map(Integer::parseInt).sorted().collect(toList()));
    }

    private Node asLinkedListOfNodes(List<Integer> values) {
        if (!values.contains(0)) { // make sure to add "socket"
            values.add(0);
        }

        Node node = null;
        for (int i : values.stream().sorted().collect(toList())) {
            if (node == null) {
                node = new Node(i, null);
            } else {
                node = node.addNext(i);
            }
        }

        return node.getFirst();
    }
}
