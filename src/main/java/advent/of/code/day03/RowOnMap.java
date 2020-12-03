package advent.of.code.day03;

import java.util.ArrayList;
import java.util.List;

public class RowOnMap {


    private final int y;
    private final String pattern;
    private final List<Cell> cells = new ArrayList<>();

    public RowOnMap(String pattern, int y) {
        this.y = y;
        this.pattern = pattern;
        addCells(this.cells, y, pattern);
    }

    private static void addCells(List<Cell> cells, int y, String pattern) {
        int offset = cells.size();
        for (int x = 0; x < pattern.length(); x++) {
            cells.add(pattern.charAt(x) == '#' ? new Tree(x + offset, y) : new OpenSquare(x + offset, y));
        }
    }

    public Cell right(int steps) {
        if (steps > cells.size()) {
            growRow(steps);
        }
        return cells.get(steps - 1);
    }

    private void growRow(int steps) {
        while (cells.size() < steps) {
            addCells(this.cells, this.y, this.pattern);
        }
    }

    public static abstract class Cell {
        final int x;
        final int y;

        Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }

        abstract boolean isOpen();
    }

    public static class OpenSquare extends Cell {
        OpenSquare(int x, int y) {
            super(x, y);
        }

        @Override
        public boolean isOpen() {
            return true;
        }
    }

    public static class Tree extends Cell {
        Tree(int x, int y) {
            super(x, y);
        }

        @Override
        public boolean isOpen() {
            return false;
        }
    }
}
