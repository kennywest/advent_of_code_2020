package advent.of.code.day11;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SeatRepositoryTest {

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
    public void shouldFindAdjacentSeats() {
        var seatRepository = SeatRepository.INSTANCE;

        Seat toTest = seatRepository.getSeat(new Position(2, 1)).orElse(null);

        assertThat(toTest).isNotNull();
        assertThat(toTest.getX()).isEqualTo(2);
        assertThat(toTest.getY()).isEqualTo(1);
        assertThat(seatRepository.getSurroundingSeats(new Position(2, 1))).hasSize(5);
        assertThat(seatRepository.getSurroundingSeats(new Position(0, 0))).hasSize(2);
        assertThat(seatRepository.getSurroundingSeats(new Position(2, 0))).hasSize(4);
        assertThat(seatRepository.getSurroundingSeats(new Position(3, 0))).hasSize(4);
        assertThat(seatRepository.getSurroundingSeats(new Position(5, 0))).hasSize(4);
        assertThat(seatRepository.getSurroundingSeats(new Position(6, 0))).hasSize(3);
        assertThat(seatRepository.getSurroundingSeats(new Position(8, 0))).hasSize(3);
        assertThat(seatRepository.getSurroundingSeats(new Position(9, 0))).hasSize(3);
    }

    @Test
    public void shouldGetAllSeats() {
        var seatRepository = SeatRepository.INSTANCE;

        assertThat(seatRepository.getAllSeats()).hasSize(71);
    }
}
