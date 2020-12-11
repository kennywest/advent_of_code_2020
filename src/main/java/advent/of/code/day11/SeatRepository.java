package advent.of.code.day11;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public final class SeatRepository {

    public static final SeatRepository INSTANCE = new SeatRepository();

    private final Map<Position, Seat> seats = new HashMap<>();

    private SeatRepository() {
    }

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

    public List<Seat> getSurroundingSeats(Seat seat) {
        return getSurroundingSeats(new Position(seat.getX(), seat.getY()));
    }

    public List<Seat> getSurroundingSeats(Position position) {
        return position.getSurroundingPositions().stream()
                .flatMap(p -> getSeat(p).stream())
                .collect(toList());
    }

    public void clear() {
        this.seats.clear();
    }

    public long getNumberOfOccupiedSeats() {
        return getAllSeats().stream()
                .filter(Seat::isOccupied)
                .count();
    }

    public void print() {
        for (int y = 0; y <= getMaxY(); y++) {
            for (int x = 0; x <= getMaxX(); x++) {
                getSeat(new Position(x, y)).ifPresentOrElse(
                        s -> System.out.print(s.isFree() ? "L " : "# "),
                        () -> System.out.print(". "));
            }
            System.out.println();
        }
    }

    private int getMaxX() {
        return this.seats.keySet().stream().map(Position::getX).max(Integer::compareTo).orElse(0);
    }

    private int getMaxY() {
        return this.seats.keySet().stream().map(Position::getY).max(Integer::compareTo).orElse(0);
    }
}
