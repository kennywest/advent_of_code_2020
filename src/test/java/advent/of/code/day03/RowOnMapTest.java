package advent.of.code.day03;

import advent.of.code.day03.RowOnMap.OpenSquare;
import advent.of.code.day03.RowOnMap.Tree;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RowOnMapTest {

    @Test
    public void shouldGoRightInSinglePattern() {
        var row = new RowOnMap("..#.", 0);

        assertThat(row.right(3))
                .usingRecursiveComparison()
                .isEqualTo(new Tree(2, 0));
    }

    @Test
    public void shouldGoRightInDoublePattern() {
        var row = new RowOnMap("..#.", 0);

        assertThat(row.right(5))
                .usingRecursiveComparison()
                .isEqualTo(new OpenSquare(4, 0));
    }

    @Test
    public void shouldGoRightInMultiplePattern() {
        var row = new RowOnMap("..#.", 0);

        assertThat(row.right(15))
                .usingRecursiveComparison()
                .isEqualTo(new Tree(14, 0));
    }
}