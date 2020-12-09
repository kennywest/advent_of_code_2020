package advent.of.code.day09;

import java.util.List;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AllNumbersTest {

    @Test
    public void shouldMoveWindow() {
        var allNumbers = new AllNumbers(List.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L));

        assertThat(allNumbers.checkNext(5).getNumbers()).containsAll(List.of(1L, 2L, 3L, 4L, 5L));
        assertThat(allNumbers.checkNext(5).getNumbers()).containsAll(List.of(2L, 3L, 4L, 5L, 6L));
        assertThat(allNumbers.checkNext(5).getNumbers()).containsAll(List.of(3L, 4L, 5L, 6L, 7L));
    }

    @Test
    public void shouldSolveSample() throws Exception {
        var allNumbers = new AllNumbers("input_9_1.txt");

        var check = allNumbers.checkNext(5);
        while (check.test()) {
            check = allNumbers.checkNext(5);
        }

        assertThat(check.getTestValue()).isEqualTo(127);
    }

    @Test
    public void shouldSolvePuzzle() throws Exception {
        var allNumbers = new AllNumbers("input_9_2.txt");

        var check = allNumbers.checkNext(25);
        while (check.test()) {
            check = allNumbers.checkNext(25);
        }

        assertThat(allNumbers.size()).isEqualTo(1000);
        assertThat(check.getTestValue()).isEqualTo(22406676);
    }
}
