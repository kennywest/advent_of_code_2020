package advent.of.code.day04;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PassportBatchProcessorTest {

    @Test
    public void shouldParseSmallFile() throws Exception {
        PassportBatchProcessor processor = new PassportBatchProcessor("input_4_1.txt");

        assertThat(processor.numberOfPassportsInBatch()).isEqualTo(4);
        assertThat(processor.muberOfValidPassports()).isEqualTo(2);
        assertThat(processor.lastLine().getIssueYear()).contains(2011);
    }

    @Test
    public void shouldParsePuzzleFile() throws Exception {
        PassportBatchProcessor processor = new PassportBatchProcessor("input_4_2.txt");

        // assertThat(processor.muberOfValidPassports()).isEqualTo(242);
        assertThat(processor.muberOfValidPassports()).isEqualTo(186);
        assertThat(processor.lastLine().getIssueYear()).contains(2017);
        assertThat(processor.lastLine().getBirthYear()).contains(1969);
    }
}