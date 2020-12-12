package advent.of.code.day12;

public final class Map2 implements Navigatable {

    public static final Map2 INSTANCE = new Map2();

    private int x;
    private int y;
    private Waypoint waypoint = new Waypoint(10, 1);

    private Map2() {
    }

    @Override
    public void north(Value value) {
        this.waypoint.north(value);
    }

    @Override
    public void south(Value value) {
        this.waypoint.south(value);
    }

    @Override
    public void east(Value value) {
        this.waypoint.east(value);
    }

    @Override
    public void west(Value value) {
        this.waypoint.west(value);
    }

    @Override
    public void forward(Value value) {
        moveTo(this.waypoint, value.getValue());
    }

    @Override
    public void turnLeft(Value degrees) {
        for (int i = 0; i < degrees.getValue() / 90; i++) {
            this.waypoint.rotateLeft90degrees();
        }
    }

    @Override
    public void turnRight(Value degrees) {
        for (int i = 0; i < degrees.getValue() / 90; i++) {
            this.waypoint.rotateRight90degrees();
        }
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
        this.waypoint = new Waypoint(10, 1);
    }

    @Override
    public String toString() {
        return "Map2{" +
                "x=" + this.x +
                ", y=" + this.y +
                ", waypoint=" + this.waypoint +
                '}';
    }

    private void moveTo(Waypoint waypoint, int value) {
        this.x = this.x + (waypoint.getX() * value);
        this.y = this.y + (waypoint.getY() * value);
    }
}
