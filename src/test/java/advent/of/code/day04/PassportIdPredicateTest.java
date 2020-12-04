package advent.of.code.day04;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class PassportIdPredicateTest {

    @Test
    public void shouldParseValidPassportId() {
        assertThat(new PassportIdPredicate().test("000000001")).isTrue();
    }

    @Test
    public void shouldParseInalidPassportId() {
        assertThat(new PassportIdPredicate().test("0000000010")).isFalse();
        assertThat(new PassportIdPredicate().test("0000000")).isFalse();
        assertThat(new PassportIdPredicate().test("aaaaaaaa")).isFalse();
    }
}