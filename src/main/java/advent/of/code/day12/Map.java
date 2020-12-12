package advent.of.code.day12;


import static advent.of.code.day12.Direction.EAST;

public final class Map implements Navigatable {
    public static final Map INSTANCE = new Map();

    private int x;
    private int y;
    private Direction direction = EAST;

    private Map() {
    }

    @Override
    public void north(Value value) {
        this.y = this.y + value.getValue();
    }

    @Override
    public void south(Value value) {
        this.y = this.y - value.getValue();
    }

    @Override
    public void east(Value value) {
        this.x = this.x + value.getValue();
    }

    @Override
    public void west(Value value) {
        this.x = this.x - value.getValue();
    }

    @Override
    public void forward(Value value) {
        this.direction.apply(value);
    }

    @Override
    public void turnLeft(Value degrees) {
        this.direction = this.direction.turnLeft(degrees);
    }


    @Override
    public void turnRight(Value degrees) {
        this.direction = this.direction.turnRight(degrees);
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public void restart() {
        this.x = 0;
        this.y = 0;
        this.direction = EAST;
    }

    @Override
    public String toString() {
        return "Map{" +
                "x=" + this.x +
                ", y=" + this.y +
                ", direction=" + this.direction +
                '}';
    }
}
