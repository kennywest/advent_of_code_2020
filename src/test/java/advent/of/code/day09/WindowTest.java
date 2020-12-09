package advent.of.code.day09;

import java.util.List;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WindowTest {

    @Test
    public void shouldFindSumInWindow() {
        var window = new Window(List.of(1L, 2L, 3L, 4L, 5L));

        assertThat(window.hasSumFor(3)).isTrue();
        assertThat(window.hasSumFor(4)).isTrue();
        assertThat(window.hasSumFor(5)).isTrue();
        assertThat(window.hasSumFor(6)).isTrue();
        assertThat(window.hasSumFor(7)).isTrue();
        assertThat(window.hasSumFor(8)).isTrue();
        assertThat(window.hasSumFor(9)).isTrue();
    }

    @Test
    public void shouldNotFindSumInWindow() {
        var window = new Window(List.of(1L, 2L, 3L, 4L, 5L));

        assertThat(window.hasSumFor(1)).isFalse();
        assertThat(window.hasSumFor(2)).isFalse();
        assertThat(window.hasSumFor(10)).isFalse();
    }

    @Test
    public void shouldFindSumInLargerWindow() {
        var window = new Window(List.of(1648L,
                1285L,
                1438L,
                1315L,
                1362L,
                1363L,
                1387L,
                1434L,
                1459L,
                1468L,
                1483L,
                1492L,
                1517L,
                1926L,
                1620L,
                1719L,
                2091L,
                2003L,
                2020L,
                3237L,
                2309L,
                2341L,
                2475L,
                3011L,
                2927L));

        assertThat(window.hasSumFor(4242)).isTrue();
    }
}
