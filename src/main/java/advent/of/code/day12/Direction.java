package advent.of.code.day12;

import static advent.of.code.day12.Action.E;
import static advent.of.code.day12.Action.N;
import static advent.of.code.day12.Action.S;
import static advent.of.code.day12.Action.W;

public enum Direction {
    NORTH {
        @Override
        public void apply(Value value) {
            N.execute(value);
        }

        @Override
        public Direction turnLeft() {
            return WEST;
        }

        @Override
        public Direction turnRight() {
            return EAST;
        }
    },
    EAST {
        @Override
        public void apply(Value value) {
            E.execute(value);
        }

        @Override
        public Direction turnLeft() {
            return NORTH;
        }

        @Override
        public Direction turnRight() {
            return SOUTH;
        }
    },
    SOUTH {
        @Override
        public void apply(Value value) {
            S.execute(value);
        }

        @Override
        public Direction turnLeft() {
            return EAST;
        }

        @Override
        public Direction turnRight() {
            return WEST;
        }
    },
    WEST {
        @Override
        public void apply(Value value) {
            W.execute(value);
        }

        @Override
        public Direction turnLeft() {
            return SOUTH;
        }

        @Override
        public Direction turnRight() {
            return NORTH;
        }
    },
    ;

    public abstract void apply(Value value);

    public Direction turnLeft(Value degrees) {
        Direction newDirection = this;

        for (int i = 0; i < degrees.getValue() / 90; i++) {
            newDirection = newDirection.turnLeft();
        }

        return newDirection;
    }

    public abstract Direction turnLeft();

    public Direction turnRight(Value degrees) {
        Direction newDirection = this;

        for (int i = 0; i < degrees.getValue() / 90; i++) {
            newDirection = newDirection.turnRight();
        }

        return newDirection;

    }

    public abstract Direction turnRight();
}
