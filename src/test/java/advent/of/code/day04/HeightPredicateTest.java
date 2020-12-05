package advent.of.code.day04;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class HeightPredicateTest {

    @Test
    public void shouldParseValidHeightInInch() {
        boolean valid = new HeightPredicate().test("70in");

        assertThat(valid).isTrue();
    }


    @Test
    public void shouldParseInvalidHeightInInch() {
        boolean valid = new HeightPredicate().test("77in");

        assertThat(valid).isFalse();
    }

    @Test
    public void shouldParseValidHeightInCm() {
        boolean valid = new HeightPredicate().test("180cm");

        assertThat(valid).isTrue();
    }

    @Test
    public void shouldParseInvalidHeightInCm() {
        boolean valid = new HeightPredicate().test("194");

        assertThat(valid).isFalse();
    }


    @Test
    public void shouldParseNull() {
        boolean valid = new HeightPredicate().test(null);

        assertThat(valid).isFalse();
    }
}
