package advent.of.code.day12;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NavigatorTest {

    @Before
    public void setUp() {
        Map.INSTANCE.restart();
        Map2.INSTANCE.restart();
    }

    @Test
    public void shouldNavigateOnSample() throws Exception {
        new Navigator("input_12_1.txt").navigate();

        assertThat(Map.INSTANCE.getManhattanDistance()).isEqualTo(25);
        assertThat(Map2.INSTANCE.getManhattanDistance()).isEqualTo(286);
    }

    @Test
    public void shouldNavigateOnPuzzle() throws Exception {
        new Navigator("input_12_2.txt").navigate();

        assertThat(Map.INSTANCE.getManhattanDistance()).isEqualTo(439);
        assertThat(Map2.INSTANCE.getManhattanDistance()).isEqualTo(12385);
    }
}
