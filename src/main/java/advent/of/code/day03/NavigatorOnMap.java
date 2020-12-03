package advent.of.code.day03;

import java.util.stream.IntStream;

public class NavigatorOnMap {

    private final RowOnMap.Cell start;
    private RowOnMap.Cell currentCell;
    private int numberOfTrees = 0;

    public NavigatorOnMap(Map map) {
        this.start = map.getStart().getFirstCell();
        reset();
    }

    private void reset() {
        this.currentCell = this.start;
        this.numberOfTrees = 0;
    }

    public int countNumberOfTreesOnPath(int right, int down) {
        reset();

        RowOnMap.Cell currentCell = navigateToNextCell(right, down);
        while (currentCell.onRow.hasNextRow()) {
            currentCell = navigateToNextCell(right, down);
        }

        return numberOfTrees;
    }

    public RowOnMap.Cell navigateToNextCell() {
        return navigateToNextCell(3, 1);
    }

    public RowOnMap.Cell navigateToNextCell(int right, int down) {
        IntStream.rangeClosed(1, right).forEach(i -> right());
        IntStream.rangeClosed(1, down).forEach(i -> down());
        checkTree();
        return this.currentCell;
    }

    private void right() {
        this.currentCell = this.currentCell.right();
    }

    private void down() {
        this.currentCell = this.currentCell.down();
    }

    private void checkTree() {
        if (this.currentCell.isTree()) {
            this.numberOfTrees++;
        }
    }

    public int getNumberOfTrees() {
        return numberOfTrees;
    }
}
