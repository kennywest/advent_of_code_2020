package advent.of.code.day09;

import java.util.List;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WindowTest {

    @Test
    public void shouldFindSumInWindow() {
        var window = new Window(List.of(1, 2, 3, 4, 5));

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
        var window = new Window(List.of(1, 2, 3, 4, 5));

        assertThat(window.hasSumFor(1)).isFalse();
        assertThat(window.hasSumFor(2)).isFalse();
        assertThat(window.hasSumFor(10)).isFalse();
    }
}
