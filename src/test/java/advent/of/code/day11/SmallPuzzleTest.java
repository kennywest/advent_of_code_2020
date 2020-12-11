package advent.of.code.day11;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SmallPuzzleTest {

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
