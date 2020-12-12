package advent.of.code.day12;

import static java.lang.Math.abs;

public interface Navigatable {
    void north(Value value);

    void south(Value value);

    void east(Value value);

    void west(Value value);

    void forward(Value value);

    void turnLeft(Value degrees);

    void turnRight(Value degrees);

    int getX();

    int getY();

    default int getManhattanDistance() {
        return abs(getX()) + abs(getY());
    }

    void restart();
}
