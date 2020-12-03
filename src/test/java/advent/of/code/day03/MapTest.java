package advent.of.code.day03;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MapTest {

    @Test
    public void shouldLoadMap() throws Exception {
        Map map = new Map("input_3_1.txt");

        assertThat(map.getStart().getPattern()).isEqualTo("..##.......");
        assertThat(map.getEnd().getPattern()).isEqualTo(".#..#...#.#");
    }
}
