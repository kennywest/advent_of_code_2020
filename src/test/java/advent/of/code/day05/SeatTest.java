package advent.of.code.day05;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class SeatTest {

    @Test
    public void shouldReturnCorrectId() {
        assertThat(new Seat(44, 5).getSeatId()).isEqualTo(357);
    }
}
