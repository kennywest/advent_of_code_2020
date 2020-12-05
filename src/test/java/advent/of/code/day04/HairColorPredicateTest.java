package advent.of.code.day04;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HairColorPredicateTest {

    @Test
    public void shouldParseValidHair() {
        assertThat(new HairColorPredicate().test("#123abc")).isTrue();
    }

    @Test
    public void shouldParseInvalidHair() {
        assertThat(new HairColorPredicate().test("#123abz")).isFalse();
        assertThat(new HairColorPredicate().test("123abc")).isFalse();
    }
}
