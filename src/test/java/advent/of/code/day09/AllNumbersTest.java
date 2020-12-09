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
        while (check.test(Window::hasSumFor)) {
            check = allNumbers.checkNext(5);
        }

        assertThat(check.getTestValue()).isEqualTo(127);
    }

    @Test
    public void shouldSolvePuzzle() throws Exception {
        var allNumbers = new AllNumbers("input_9_2.txt");

        var check = allNumbers.checkNext(25);
        while (check.test(Window::hasSumFor)) {
            check = allNumbers.checkNext(25);
        }

        assertThat(allNumbers.size()).isEqualTo(1000);
        assertThat(check.getTestValue()).isEqualTo(22406676);
    }

    @Test
    public void shouldFindWindowHavingSum127() throws Exception {
        var allNumbers = new AllNumbers("input_9_1.txt");

        Window window = allNumbers.findWindowHavindSum(127);
        assertThat(window.getNumbers()).containsAll(List.of(15L, 25L, 47L, 40L));
        assertThat(window.getSmallestNumber()).isEqualTo(15);
        assertThat(window.getBiggestNumber()).isEqualTo(47);
        assertThat(window.getBiggestNumber() + window.getSmallestNumber()).isEqualTo(62);
    }

    @Test
    public void shouldFindWindowHavingSum22406676() throws Exception {
        var allNumbers = new AllNumbers("input_9_2.txt");

        Window window = allNumbers.findWindowHavindSum(22406676);
        assertThat(window.getBiggestNumber() + window.getSmallestNumber()).isEqualTo(2942387);
    }
}
