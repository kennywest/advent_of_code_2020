package advent.of.code.day11;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SeatTest {

    @Before
    public void setUp() throws Exception {
        var seatRepository = SeatRepository.INSTANCE;
        new Grid("input_11_1.txt").getListOfSeats().forEach(seatRepository::save);
    }

    @After
    public void tearDown() {
        SeatRepository.INSTANCE.clear();
    }

    @Test
    public void shouldChangeToOccupied() {
        var seatRepository = SeatRepository.INSTANCE;
        var change = new ChangedStateListener();

        Seat seat = seatRepository.getSeat(new Position(0, 0)).orElse(null);
        seat.tic();

        assertThat(seat.isFree()).isTrue();
        assertThat(change.isStateChanged()).isFalse();

        seat.commit(change);

        assertThat(seat.isOccupied()).isTrue();
        assertThat(change.isStateChanged()).isTrue();
    }

    @Test
    public void shouldSettle() {
        var seatRepository = SeatRepository.INSTANCE;

        while (true) {
            var change = new ChangedStateListener();
            seatRepository.getAllSeats().forEach(Seat::tic);
            seatRepository.getAllSeats().forEach(s -> s.commit(change));
            //seatRepository.print();

            if (!change.isStateChanged()) {
                break;
            }
        }

        assertThat(seatRepository.getNumberOfOccupiedSeats()).isEqualTo(37);
    }
}
