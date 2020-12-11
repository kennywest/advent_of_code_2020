package advent.of.code.day11;

import java.util.List;

public interface SurroundingSeatsSpotter {

    default List<Seat> getSurroundingSeats(Seat seat) {
        return getSurroundingSeats(new Position(seat.getX(), seat.getY()));
    }

    List<Seat> getSurroundingSeats(Position position);
}
