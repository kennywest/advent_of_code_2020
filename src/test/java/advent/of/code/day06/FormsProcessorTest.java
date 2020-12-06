package advent.of.code.day06;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FormsProcessorTest {

    @Test
    public void shouldHaveCorrectNumberOfGroups() throws Exception {
        var processor = new FormsProcessor("input_6_1.txt");

        assertThat(processor.getGroups()).hasSize(5);
    }

    @Test
    public void shouldCountAnswersForAllGroups() throws Exception {
        var processor = new FormsProcessor("input_6_1.txt");

        assertThat(processor.sumNumberOfAnswers()).isEqualTo(11);
    }

    @Test
    public void shouldCountCommonAnswersForAllGroups() throws Exception {
        var processor = new FormsProcessor("input_6_1.txt");

        assertThat(processor.sumCommonAnswers()).isEqualTo(6);
    }

    @Test
    public void shouldCountAnswersForAllGroupsInPuzzle() throws Exception {
        var processor = new FormsProcessor("input_6_2.txt");

        assertThat(processor.sumNumberOfAnswers()).isEqualTo(6662);
    }

    @Test
    public void shouldCountCommonAnswersForAllGroupsInPuzzle() throws Exception {
        var processor = new FormsProcessor("input_6_2.txt");

        assertThat(processor.sumCommonAnswers()).isEqualTo(3382);
    }
}
