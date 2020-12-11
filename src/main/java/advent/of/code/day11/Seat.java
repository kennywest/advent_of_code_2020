package advent.of.code.day11;

import static advent.of.code.day11.Seat.State.FREE;
import static advent.of.code.day11.Seat.State.OCCUPIED;

public class Seat {
    private final int x;
    private final int y;
    private final SurroundingSeatsSpotter spotter;
    private State currentState;
    private State nextState;

    public Seat(int x, int y, SurroundingSeatsSpotter spotter) {
        this(x, y, spotter, FREE);
    }

    public Seat(int x, int y, SurroundingSeatsSpotter spotter, State currentState) {
        this.x = x;
        this.y = y;
        this.spotter = spotter;
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
        if (this.currentState == FREE && surroundingSeatsAreAllFree()) {
            this.nextState = OCCUPIED;
        } else if (this.currentState == OCCUPIED && numberOfOccupiedSurroundingSeatsIsAcceptable()) {
            this.nextState = FREE;
        }
    }

    private boolean surroundingSeatsAreAllFree() {
        return this.spotter.getSurroundingSeats(this).stream().allMatch(Seat::isFree);
    }

    private boolean numberOfOccupiedSurroundingSeatsIsAcceptable() {
        return this.spotter.numberOfOccupiedSurroundingSeatsIsAcceptable(this);
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
