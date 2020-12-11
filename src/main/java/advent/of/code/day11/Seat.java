package advent.of.code.day11;

import java.util.List;

import static advent.of.code.day11.Seat.State.FREE;
import static advent.of.code.day11.Seat.State.OCCUPIED;

public class Seat {
    private final int x;
    private final int y;
    private List<Seat> neighbours;
    private State currentState;
    private State nextState;

    public Seat(int x, int y) {
        this(x, y, FREE);
    }

    public Seat(int x, int y, State currentState) {
        this.x = x;
        this.y = y;
        this.currentState = currentState;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean isFree() {
        return this.currentState == FREE;
    }

    public boolean isOccupied() {
        return this.currentState == OCCUPIED;
    }

    public void tic() {
        if (this.currentState == FREE && adjecentSeatsAraAllFree()) {
            this.nextState = OCCUPIED;
        } else if (this.currentState == OCCUPIED && numberOfAdjecentSeatsOccupied() >= 4) {
            this.nextState = FREE;
        }
    }

    private boolean adjecentSeatsAraAllFree() {
        return SeatRepository.INSTANCE.getSurroundingSeats(this).stream().allMatch(Seat::isFree);
    }

    private long numberOfAdjecentSeatsOccupied() {
        return SeatRepository.INSTANCE.getSurroundingSeats(this).stream()
                .filter(Seat::isOccupied)
                .count();
    }

    public void commit(ChangedStateListener listener) {
        if (this.nextState != null) {
            this.currentState = this.nextState;
            this.nextState = null;
            listener.recordChange();
        }
    }

    @Override
    public String toString() {
        return "Seat{" +
                "x=" + this.x +
                ", y=" + this.y +
                ", currentState=" + this.currentState +
                '}';
    }

    enum State {
        OCCUPIED,
        FREE;
    }
}
