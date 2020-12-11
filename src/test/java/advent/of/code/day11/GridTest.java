package advent.of.code.day11;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GridTest {

    @Test
    public void shouldGetListOfSeats() throws Exception {
        var grid = new Grid("input_11_1.txt");

        assertThat(grid.getListOfSeats()).hasSize(71);
    }
}
