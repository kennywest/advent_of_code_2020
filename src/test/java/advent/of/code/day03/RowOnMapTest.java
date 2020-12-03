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
                .ignoringFields("onRow")
                .isEqualTo(new Tree(2, 0, null));
    }

    @Test
    public void shouldGoRightInDoublePattern() {
        var row = new RowOnMap("..#.", 0);

        assertThat(row.right(5))
                .usingRecursiveComparison()
                .ignoringFields("onRow")
                .isEqualTo(new OpenSquare(4, 0, null));
    }

    @Test
    public void shouldGoRightInMultiplePattern() {
        var row = new RowOnMap("..#.", 0);

        assertThat(row.right(15))
                .usingRecursiveComparison()
                .ignoringFields("onRow")
                .isEqualTo(new Tree(14, 0, null));
    }

    @Test
    public void shouldGoRightTwice() {
        var row = new RowOnMap("..#.", 0);

        assertThat(row.right(row.right(10), 5))
                .usingRecursiveComparison()
                .ignoringFields("onRow")
                .isEqualTo(new Tree(14, 0, null));
    }

    @Test
    public void shouldGoRightAndDown() {
        var row = new RowOnMap("..##.......", 0);
        row.next("#...#...#..").next(".#....#..#.");

        assertThat(row.right(3).down().right(2).right(1).down())
                .usingRecursiveComparison()
                .ignoringFields("onRow")
                .isEqualTo(new Tree(5, 2, null));
    }
}