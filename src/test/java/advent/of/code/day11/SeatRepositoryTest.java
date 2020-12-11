package advent.of.code.day11;

import java.util.List;

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
        assertThat(seatRepository.getAdjecentSurroundingSeats(new Position(2, 1))).hasSize(5);
        assertThat(seatRepository.getAdjecentSurroundingSeats(new Position(0, 0))).hasSize(2);
        assertThat(seatRepository.getAdjecentSurroundingSeats(new Position(2, 0))).hasSize(4);
        assertThat(seatRepository.getAdjecentSurroundingSeats(new Position(3, 0))).hasSize(4);
        assertThat(seatRepository.getAdjecentSurroundingSeats(new Position(5, 0))).hasSize(4);
        assertThat(seatRepository.getAdjecentSurroundingSeats(new Position(6, 0))).hasSize(3);
        assertThat(seatRepository.getAdjecentSurroundingSeats(new Position(8, 0))).hasSize(3);
        assertThat(seatRepository.getAdjecentSurroundingSeats(new Position(9, 0))).hasSize(3);
    }

    @Test
    public void shouldGetAllSeats() {
        var seatRepository = SeatRepository.INSTANCE;

        assertThat(seatRepository.getAllSeats()).hasSize(71);
    }

    @Test
    public void shouldSeeEmptySeat() {
        shouldSeeEmptySeat(List.of(
                ".............",
                ".L.L.#.#.#.#.",
                "............."), 1, 1);

        shouldSeeEmptySeat(List.of(
                ".............",
                ".#.#.#.#.L.L.",
                "............."), 11, 1);

        shouldSeeEmptySeat(List.of(
                ".L...........",
                ".............",
                ".L.#.#.#.#.#.",
                "............."), 1, 2);

        shouldSeeEmptySeat(List.of(
                ".............",
                ".L.#.#.#.#.#.",
                ".............",
                ".L..........."), 1, 1);

        shouldSeeEmptySeat(List.of(
                "...L.........",
                ".............",
                ".L.#.#.#.#.#.",
                "............."), 1, 2);

        shouldSeeEmptySeat(List.of(
                ".............",
                ".L.#.#.#.#.#.",
                ".............",
                "...L........."), 1, 1);

        shouldSeeEmptySeat(List.of(
                ".............",
                "...L.#.#.#.#.",
                ".............",
                ".L..........."), 3, 1);
    }

    private void shouldSeeEmptySeat(List<String> input, int x, int y) {
        var seatRepository = SeatRepository.INSTANCE;
        seatRepository.clear();
        new Grid(input).getListOfSeats().forEach(seatRepository::save);

        assertThat(seatRepository.getAdjecentSurroundingSeats(new Position(x, y))).hasSize(0);
        assertThat(seatRepository.getAllVisibleSurroundingSeats(new Position(x, y)).stream().filter(Seat::isFree)).hasSize(1);
    }

    @Test
    public void shouldSeeEightOccupiedSeats() {
        var seatRepository = SeatRepository.INSTANCE;
        seatRepository.clear();
        new Grid(List.of(
                ".......#.",
                "...#.....",
                ".#.......",
                ".........",
                "..#L....#",
                "....#....",
                ".........",
                "#........",
                "...#.....")).getListOfSeats().forEach(seatRepository::save);

        assertThat(seatRepository.getAdjecentSurroundingSeats(new Position(3, 4))).hasSize(2);
        assertThat(seatRepository.getAllVisibleSurroundingSeats(new Position(3, 4))).hasSize(8);
    }
}
