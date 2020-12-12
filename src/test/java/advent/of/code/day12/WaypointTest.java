package advent.of.code.day12;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WaypointTest {

    @Test
    public void shouldRotateRight() {
        var waypoint = new Waypoint(-10, 4);

        waypoint.rotateRight90degrees();
        assertThat(waypoint.getX()).isEqualTo(4);
        assertThat(waypoint.getY()).isEqualTo(10);

        waypoint.rotateRight90degrees();
        assertThat(waypoint.getX()).isEqualTo(10);
        assertThat(waypoint.getY()).isEqualTo(-4);

        waypoint.rotateRight90degrees();
        assertThat(waypoint.getX()).isEqualTo(-4);
        assertThat(waypoint.getY()).isEqualTo(-10);

        waypoint.rotateRight90degrees();
        assertThat(waypoint.getX()).isEqualTo(-10);
        assertThat(waypoint.getY()).isEqualTo(4);
    }

    @Test
    public void shouldRotateLeft() {
        var waypoint = new Waypoint(-10, 4);

        waypoint.rotateLeft90degrees();
        assertThat(waypoint.getX()).isEqualTo(-4);
        assertThat(waypoint.getY()).isEqualTo(-10);

        waypoint.rotateLeft90degrees();
        assertThat(waypoint.getX()).isEqualTo(10);
        assertThat(waypoint.getY()).isEqualTo(-4);

        waypoint.rotateLeft90degrees();
        waypoint.rotateLeft90degrees();
        assertThat(waypoint.getX()).isEqualTo(-10);
        assertThat(waypoint.getY()).isEqualTo(4);
    }
}
