package advent.of.code.day10;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AdaptersTest {

    @Test
    public void shouldFindHighestRating() {
        var adapters = new Adapters(List.of(16, 10, 15, 5, 1, 11, 7, 19, 6, 12, 4));

        assertThat(adapters.getHighestRating()).isEqualTo(19);
    }

    @Test
    public void shouldFindDifferencesInSmallSample() {
        var adapters = new Adapters(List.of(16, 10, 15, 5, 1, 11, 7, 19, 6, 12, 4));

        assertThat(adapters.numberOfDifferencesOfOneJolt()).isEqualTo(7);
        assertThat(adapters.numberOfDifferencesOfThreeJolts()).isEqualTo(5);
    }

    @Test
    public void shouldFindDifferencesInLargerSample() throws Exception {
        var adapters = new Adapters("input_10_1.txt");

        assertThat(adapters.numberOfDifferencesOfOneJolt()).isEqualTo(22);
        assertThat(adapters.numberOfDifferencesOfThreeJolts()).isEqualTo(10);
    }

    @Test
    public void shouldFindDifferencesInPuzzleInput() throws Exception {
        var adapters = new Adapters("input_10_2.txt");

        assertThat(adapters.numberOfDifferencesOfOneJolt()).isEqualTo(72);
        assertThat(adapters.numberOfDifferencesOfThreeJolts()).isEqualTo(37);
    }

    @Test
    public void shouldFindNumberOfValidCombinations() {
        var adapters = new Adapters(List.of(16, 10, 15, 5, 1, 11, 7, 19, 6, 12, 4));

        assertThat(adapters.getNumberOfCombinations()).isEqualTo(8);
    }

    @Ignore
    @Test
    public void shouldFindNumberOfValidCombinationsInLargerSample() throws Exception {
        var adapters = new Adapters("input_10_1.txt");

        assertThat(adapters.getNumberOfCombinations()).isEqualTo(19208);
    }
}
