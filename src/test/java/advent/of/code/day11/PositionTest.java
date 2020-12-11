package advent.of.code.day11;

import java.util.List;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    @Test
    public void shouldFindAllVisiblePositionsOnSmallSquare() {
        var position = new Position(1, 1);

        var positions = position.getAllVisibleSurroundingPositions(2, 2);

        assertThat(positions).hasSize(8);
    }

    @Test
    public void shouldFindAllVisiblePositionsOnBiggerSquare() {
        var position = new Position(2, 3);

        var positions = position.getAllVisibleSurroundingPositions(5, 5);

        assertThat(positions).containsAll(List.of(
                new Position(2, 0),
                new Position(2, 1),
                new Position(2, 2),
                new Position(2, 4),
                new Position(2, 5),
                new Position(0, 3),
                new Position(1, 3),
                new Position(3, 3),
                new Position(4, 3),
                new Position(5, 3),
                new Position(0, 1),
                new Position(1, 2),
                new Position(1, 4),
                new Position(0, 5),

                new Position(3, 2),
                new Position(4, 1),
                new Position(5, 0),
                new Position(3, 4),
                new Position(4, 5)
        ));

        position = new Position(1, 1);

        assertThat(position.getAllVisibleSurroundingPositions(5, 5)).hasSize(17);
    }
}
