package advent.of.code.day03;

import java.util.ArrayList;
import java.util.List;

public class RowOnMap {

    private final int y;
    private final String pattern;
    private final List<Cell> cells = new ArrayList<>();
    private RowOnMap nextRow;

    public RowOnMap(String pattern, int y) {
        this.y = y;
        this.pattern = pattern;
        addCells(this.cells, y, pattern, this);
    }

    private static void addCells(List<Cell> cells, int y, String pattern, RowOnMap onRow) {
        int offset = cells.size();
        for (int x = 0; x < pattern.length(); x++) {
            cells.add(pattern.charAt(x) == '#' ? new Tree(x + offset, y, onRow) : new OpenSquare(x + offset, y, onRow));
        }
    }

    public Cell getFirstCell() {
        return this.cells.get(0);
    }

    public RowOnMap next(String pattern) {
        this.nextRow = new RowOnMap(pattern, y + 1);
        return this.nextRow;
    }

    public boolean hasNextRow() {
        return this.nextRow != null;
    }

    public Cell right(int steps) {
        if (steps > cells.size()) {
            growRow(steps);
        }
        return cells.get(steps - 1);
    }

    public Cell right(Cell from, int steps) {
        return right(from.x + steps + 1);
    }

    public Cell down(Cell from) {
        if (this.nextRow != null) {
            return nextRow.right(from.x + 1);
        }
        return from;
    }

    public String getPattern() {
        return pattern;
    }

    private void growRow(int steps) {
        while (cells.size() < steps) {
            addCells(this.cells, this.y, this.pattern, this);
        }
    }

    public static abstract class Cell {
        final RowOnMap onRow;
        final int x;
        final int y;

        Cell(int x, int y, RowOnMap onRow) {
            this.x = x;
            this.y = y;
            this.onRow = onRow;
        }

        Cell down() {
            return onRow.down(this);
        }

        Cell right() {
            return right(1);
        }

        Cell right(int steps) {
            return onRow.right(this, steps);
        }

        abstract boolean isTree();

        @Override
        public String toString() {
            return "{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static class OpenSquare extends Cell {
        OpenSquare(int x, int y, RowOnMap onRow) {
            super(x, y, onRow);
        }

        @Override
        public boolean isTree() {
            return false;
        }
    }

    public static class Tree extends Cell {
        Tree(int x, int y, RowOnMap onRow) {
            super(x, y, onRow);
        }

        @Override
        public boolean isTree() {
            return true;
        }
    }
}
