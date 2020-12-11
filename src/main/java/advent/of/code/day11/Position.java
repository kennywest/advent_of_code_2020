package advent.of.code.day11;

import java.util.ArrayList;
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

    List<Position> getAllVisibleSurroundingPositions(int maxX, int maxY) {
        List<Position> allVisibleSurroundingPositions = new ArrayList<>();

        allVisibleSurroundingPositions.addAll(allPositionsOnXAxis(maxX, maxY));
        allVisibleSurroundingPositions.addAll(allPositionsOnYAxis(maxX, maxY));
        allVisibleSurroundingPositions.addAll(getAllPositionsOnDiagonal(maxX, maxY));

        return allVisibleSurroundingPositions;
    }

    private List<Position> getAllPositionsOnDiagonal(int maxX, int maxY) {
        List<Position> positions = new ArrayList<>();

        int y1 = this.y;
        int y2 = this.y;
        for (int x = this.x; x >= 0; x--) {
            addValidPosition(positions, x, y1--, maxX, maxY);
            addValidPosition(positions, x, y2++, maxX, maxY);
        }

        y1 = this.y;
        y2 = this.y;
        for (int x = this.x; x <= maxX; x++) {
            addValidPosition(positions, x, y1--, maxX, maxY);
            addValidPosition(positions, x, y2++, maxX, maxY);
        }

        return positions;
    }

    private List<Position> allPositionsOnXAxis(int maxX, int maxY) {
        List<Position> positions = new ArrayList<>();

        for (int x = 0; x <= maxX; x++) {
            addValidPosition(positions, x, this.y, maxX, maxY);
        }

        return positions;
    }

    private List<Position> allPositionsOnYAxis(int maxX, int maxY) {
        List<Position> positions = new ArrayList<>();

        for (int y = 0; y <= maxY; y++) {
            addValidPosition(positions, this.x, y, maxX, maxY);
        }

        return positions;
    }

    private void addValidPosition(List<Position> positions, int x, int y, int maxX, int maxY) {
        if (isValid(x, y, maxX, maxY) && (x != this.x || y != this.y)) {
            positions.add(new Position(x, y));
        }
    }

    public boolean isValid(int maxX, int maxY) {
        return isValid(this.x, this.y, maxX, maxY);
    }

    private boolean isValid(int x, int y, int maxX, int maxY) {
        return x >= 0 && x <= maxX && y >= 0 && y <= maxY;
    }
}
