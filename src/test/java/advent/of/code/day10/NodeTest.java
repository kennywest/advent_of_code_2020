package advent.of.code.day10;

import java.util.List;

import org.junit.Test;

import static com.google.common.io.Resources.getResource;
import static com.google.common.io.Resources.readLines;
import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

public class NodeTest {

    @Test
    public void shouldFindFirst() {
        Node start = asLinkedListOfNodes(List.of(16, 10, 15, 5, 1, 11, 7, 19, 6, 12, 4));

        assertThat(start.getValue()).isEqualTo(1);
    }

    @Test
    public void shouldFindAllPaths() throws Exception {
        Node node = asLinkedListOfNodes(List.of(16, 10, 15, 5, 1, 11, 7, 19, 6, 12, 4));
        //Node node = asLinkedListOfNodes(List.of(3, 4, 6, 7));
        //Node node = asLinkedListOfNodes("input_10_1.txt");

        while (node.hasNext()) {
            System.out.println(node.getValue() + ": " + node.getNextPossibleNodes());
            node = node.next();
        }
    }

    Node asLinkedListOfNodes(String file) throws Exception {
        return asLinkedListOfNodes(readLines(getResource(file), UTF_8).stream().map(Integer::parseInt).sorted().collect(toList()));
    }

    Node asLinkedListOfNodes(List<Integer> values) {
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
