package advent.of.code.day12;

public class Waypoint {
    private int x;
    private int y;

    public Waypoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void north(advent.of.code.day12.Value value) {
        this.y = this.y + value.getValue();
    }

    public void south(advent.of.code.day12.Value value) {
        this.y = this.y - value.getValue();
    }

    public void east(advent.of.code.day12.Value value) {
        this.x = this.x + value.getValue();
    }

    public void west(advent.of.code.day12.Value value) {
        this.x = this.x - value.getValue();
    }

    public void rotateRight90degrees() {
        int currentX = this.x;
        int currentY = this.y;

        this.x = currentY;
        this.y = -1 * currentX;
    }

    public void rotateLeft90degrees() {
        int currentX = this.x;
        int currentY = this.y;

        this.x = -1 * currentY;
        this.y = currentX;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Override
    public String toString() {
        return "Waypoint{" +
                "x=" + this.x +
                ", y=" + this.y +
                '}';
    }
}
