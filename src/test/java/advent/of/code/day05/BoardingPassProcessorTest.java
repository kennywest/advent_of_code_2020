package advent.of.code.day05;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardingPassProcessorTest {

    @Test
    public void ShouldFindSeatWithHighestNumber() throws Exception {
        var processor = new BoardingPassProcessor("input_5_1.txt");

        assertThat(processor.getBoardingPasses()).hasSize(3);
        assertThat(processor.getSeatWithHighestNumber().getSeatId()).isEqualTo(820);
    }

    @Test
    public void ShouldFindSeatWithHighestNumberInPuzzleInput() throws Exception {
        var processor = new BoardingPassProcessor("input_5_2.txt");

        assertThat(processor.getBoardingPasses()).hasSize(908);
        assertThat(processor.getSeatWithHighestNumber().getSeatId()).isEqualTo(953);
    }

    @Test
    public void shouldFindSeatIdsWithoutBoardingPass() throws Exception {
        var processor = new BoardingPassProcessor("input_5_2.txt");

        assertThat(processor.getMySeatId()).isEqualTo(615);
    }
}
