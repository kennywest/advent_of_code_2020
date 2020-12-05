package advent.of.code.day02;

import org.junit.Test;

import static advent.of.code.day02.PasswordPolicyStrategy.ONE;
import static advent.of.code.day02.PasswordPolicyStrategy.TWO;
import static org.assertj.core.api.Assertions.assertThat;

public class PasswordFileTest {

    @Test
    public void shouldParseFile1WithFirstStrategy() throws Exception {
        var file = new PasswordFile("input_2_1.txt", ONE);

        assertThat(file.validPasswordCount()).isEqualTo(2);
    }

    @Test
    public void shouldParseFile1WithSecondStrategy() throws Exception {
        var file = new PasswordFile("input_2_1.txt", TWO);

        assertThat(file.validPasswordCount()).isEqualTo(1);
    }

    @Test
    public void shouldParseFile2WithFirstStrategy() throws Exception {
        var file = new PasswordFile("input_2_2.txt", ONE);

        assertThat(file.validPasswordCount()).isEqualTo(625);
    }

    @Test
    public void shouldParseFile2WithSecondStrategy() throws Exception {
        var file = new PasswordFile("input_2_2.txt", TWO);

        assertThat(file.validPasswordCount()).isEqualTo(391);
    }
}
