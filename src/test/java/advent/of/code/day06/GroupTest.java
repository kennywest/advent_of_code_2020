package advent.of.code.day06;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GroupTest {

    @Test
    public void shouldCountAnswersFromSinglePerson() {
        var group = new Group();
        group.addFormWithAnswers("abc");

        assertThat(group.countNumberOfAnswers()).isEqualTo(3);
    }

    @Test
    public void shouldCountAnswersFromAGroupOfPersons() {
        var group = new Group();
        group.addFormWithAnswers("abcx");
        group.addFormWithAnswers("abcy");
        group.addFormWithAnswers("abc6");


        assertThat(group.countNumberOfAnswers()).isEqualTo(6);
    }

    @Test
    public void shouldCountCommonAnswersFromAGroupOfPersons() {
        var group = new Group();
        group.addFormWithAnswers("abcx");
        group.addFormWithAnswers("abcy");
        group.addFormWithAnswers("abcz");


        assertThat(group.countCommonOfAnswers()).isEqualTo(3);
    }
}
