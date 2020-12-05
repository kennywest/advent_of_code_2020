package advent.of.code.day05;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class BoardingPassTest {

    @Test
    public void shouldFindSeat() {
        assertThat(new BoardingPass("FBFBBFFRLR").getSeat()).isEqualTo(new Seat(44, 5));
    }
}
