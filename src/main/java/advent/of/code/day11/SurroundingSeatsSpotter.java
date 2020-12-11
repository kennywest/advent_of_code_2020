package advent.of.code.day11;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface SurroundingSeatsSpotter {

    default List<Seat> getSurroundingSeats(Seat seat) {
        return getSurroundingSeats(new Position(seat.getX(), seat.getY()));
    }

    List<Seat> getSurroundingSeats(Position position);

    boolean numberOfOccupiedSurroundingSeatsIsAcceptable(Seat seat);

    final class Easy implements SurroundingSeatsSpotter {

        @Override
        public List<Seat> getSurroundingSeats(Position position) {
            return SeatRepository.INSTANCE.getAdjecentSurroundingSeats(position);
        }

        @Override
        public boolean numberOfOccupiedSurroundingSeatsIsAcceptable(Seat seat) {
            return SeatRepository.INSTANCE.getAdjecentSurroundingSeats(seat).stream()
                    .filter(Seat::isOccupied)
                    .count() >= 4;
        }
    }

    final class Difficult implements SurroundingSeatsSpotter {
        private final Map<Position, List<Seat>> surroundingSeats = new HashMap<>();

        @Override
        public List<Seat> getSurroundingSeats(Position position) {
            if (this.surroundingSeats.get(position) == null) {
                this.surroundingSeats.put(position, SeatRepository.INSTANCE.getAllVisibleSurroundingSeats(position));
            }

            return this.surroundingSeats.get(position);
        }

        @Override
        public boolean numberOfOccupiedSurroundingSeatsIsAcceptable(Seat seat) {
            return getSurroundingSeats(new Position(seat.getX(), seat.getY())).stream()
                    .filter(Seat::isOccupied)
                    .count() >= 5;
        }
    }
}
