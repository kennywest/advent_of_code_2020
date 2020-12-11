package advent.of.code.day11;

import java.util.List;

import lombok.Value;

@Value
public class Position {
    int x;
    int y;

    List<Position> getSurroundingPositions() {
        return List.of(
                new Position(this.x - 1, this.y),
                new Position(this.x - 1, this.y - 1),
                new Position(this.x, this.y - 1),
                new Position(this.x + 1, this.y - 1),
                new Position(this.x + 1, this.y),
                new Position(this.x + 1, this.y + 1),
                new Position(this.x, this.y + 1),
                new Position(this.x - 1, this.y + 1)
        );
    }
}
