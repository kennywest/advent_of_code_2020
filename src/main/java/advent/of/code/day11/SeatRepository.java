package advent.of.code.day11;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class SeatRepository {
    private final Map<Position, Seat> seats = new HashMap<>();

    public Optional<Seat> getSeat(Position position) {
        return Optional.ofNullable(this.seats.get(position));
    }

    public List<Seat> getAllSeats() {
        return new ArrayList<>(this.seats.values());
    }

    public Seat save(Seat seat) {
        this.seats.put(new Position(seat.getX(), seat.getY()), seat);
        return seat;
    }

    public List<Seat> getSurroundingSeats(Position position) {
        return position.getSurroundingPositions().stream()
                .flatMap(p -> getSeat(p).stream())
                .collect(toList());
    }
}
