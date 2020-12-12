package advent.of.code.day12;

import org.junit.Test;

import static advent.of.code.day12.Direction.EAST;
import static advent.of.code.day12.Direction.NORTH;
import static advent.of.code.day12.Direction.SOUTH;
import static advent.of.code.day12.Direction.WEST;
import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {

    @Test
    public void shouldTurnLeft() {
        assertThat(NORTH.turnLeft(new Value(90))).isEqualTo(WEST);
        assertThat(NORTH.turnLeft(new Value(180))).isEqualTo(SOUTH);
        assertThat(NORTH.turnLeft(new Value(270))).isEqualTo(EAST);
        assertThat(NORTH.turnLeft(new Value(360))).isEqualTo(NORTH);
    }

    @Test
    public void shouldTurnRight() {
        assertThat(NORTH.turnRight(new Value(90))).isEqualTo(EAST);
        assertThat(NORTH.turnRight(new Value(180))).isEqualTo(SOUTH);
        assertThat(NORTH.turnRight(new Value(270))).isEqualTo(WEST);
        assertThat(NORTH.turnRight(new Value(360))).isEqualTo(NORTH);
    }
}
