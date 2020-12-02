package advent.of.code.day02;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PasswordPolicyTest {

    @Test
    public void shouldParseInput() {
        var policy = new PasswordPolicy1("11-42 x");

        assertThat(policy.getAtLeast()).isEqualTo(11);
        assertThat(policy.getAtMost()).isEqualTo(42);
        assertThat(policy.getCharacter()).isEqualTo("x");
    }

    @Test
    public void shouldValidatePassword() {
        var policy = new PasswordPolicy1("1-3 a");

        assertThat(policy.isValid("abcde")).isTrue();
        assertThat(policy.isValid("abacade")).isTrue();
    }

}
