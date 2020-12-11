package advent.of.code.day11;

import java.util.List;

import static advent.of.code.day11.Seat.State.FREE;

public class Seat {
    private final int x;
    private final int y;
    private List<Seat> neighbours;
    private State currentState;
    private State nextState;

    public Seat(int x, int y) {
        this.x = x;
        this.y = y;
        this.currentState = FREE;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    enum State {
        OCCUPIED,
        FREE;
    }
}
