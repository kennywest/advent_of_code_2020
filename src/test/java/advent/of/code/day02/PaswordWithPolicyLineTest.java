package advent.of.code.day02;


import org.junit.Test;

import static advent.of.code.day02.PasswordPolicyStrategy.ONE;
import static advent.of.code.day02.PasswordPolicyStrategy.TWO;
import static org.assertj.core.api.Assertions.assertThat;

public class PaswordWithPolicyLineTest {

    @Test
    public void shouldParseValidLine() {
        assertThat(new PaswordWithPolicyLine("1-3 a: abcde  ", ONE).isValid()).isTrue();
        assertThat(new PaswordWithPolicyLine("1-3 a: abcde  ", TWO).isValid()).isTrue();
    }

    @Test
    public void shouldParseInvalidLine() {
        assertThat(new PaswordWithPolicyLine("1-3 b: cdefg", ONE).isValid()).isFalse();
        assertThat(new PaswordWithPolicyLine("1-3 b: cdefg", TWO).isValid()).isFalse();
        assertThat(new PaswordWithPolicyLine("2-9 c: ccccccccc", TWO).isValid()).isFalse();
    }
}