package advent.of.code.day11;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.stream.Collectors.toList;

public final class SeatRepository {

    public static final SeatRepository INSTANCE = new SeatRepository();

    private final Map<Position, Seat> seats = new HashMap<>();
    private final SurroundingSeatsSpotter surroundingSeatsSpotter;

    private SeatRepository() {
        this.surroundingSeatsSpotter = SeatRepository.this::getAdjecentSurroundingSeats;
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
        return this.surroundingSeatsSpotter.getSurroundingSeats(seat);
    }

    public List<Seat> getSurroundingSeats(Position position) {
        return this.surroundingSeatsSpotter.getSurroundingSeats(position);
    }

    private List<Seat> getAdjecentSurroundingSeats(Seat seat) {
        return getAdjecentSurroundingSeats(new Position(seat.getX(), seat.getY()));
    }

    private List<Seat> getAdjecentSurroundingSeats(Position position) {
        return position.getSurroundingPositions().stream()
                .flatMap(p -> getSeat(p).stream())
                .collect(toList());
    }

    public List<Seat> getAllVisibleSurroundingSeats(Position position) {
        return position.getSurroundingPositions().stream()
                .flatMap(p -> getSeat(p).or(() -> getFirstVisibleSeat(getSeat(position).get(), p)).stream())
                .collect(toList());
    }

    public Optional<Seat> getFirstVisibleSeat(Seat from, Position noSeat) {
        if (!noSeat.isValid(getMaxX(), getMaxY())) {
            return empty();
        }

        Optional<Seat> seat = getSeat(noSeat);
        if (seat.isPresent()) {
            return seat;
        }

        if (noSeat.getX() < from.getX() && noSeat.getY() < from.getY()) {
            return getFirstVisibleSeat(from, new Position(noSeat.getX() - 1, noSeat.getY() - 1));
        }

        if (noSeat.getX() < from.getX() && noSeat.getY() > from.getY()) {
            return getFirstVisibleSeat(from, new Position(noSeat.getX() - 1, noSeat.getY() + 1));
        }

        if (noSeat.getX() > from.getX() && noSeat.getY() < from.getY()) {
            return getFirstVisibleSeat(from, new Position(noSeat.getX() + 1, noSeat.getY() - 1));
        }

        if (noSeat.getX() > from.getX() && noSeat.getY() > from.getY()) {
            return getFirstVisibleSeat(from, new Position(noSeat.getX() + 1, noSeat.getY() + 1));
        }

        if (from.getX() == noSeat.getX()) {
            if (from.getY() > noSeat.getY()) {
                return getFirstVisibleSeat(from, new Position(noSeat.getX(), noSeat.getY() - 1));
            } else {
                return getFirstVisibleSeat(from, new Position(noSeat.getX(), noSeat.getY() + 1));
            }
        }

        if (from.getY() == noSeat.getY()) {
            if (from.getX() > noSeat.getX()) {
                return getFirstVisibleSeat(from, new Position(noSeat.getX() - 1, noSeat.getY()));
            } else {
                return getFirstVisibleSeat(from, new Position(noSeat.getX() + 1, noSeat.getY()));
            }
        }


        return empty();
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
