package advent.of.code.day05;

import lombok.Value;

@Value
public class BoardingPass {
    int designatedRow;
    int designatedColumn;

    public BoardingPass(String code) {
        this.designatedRow = findRowOrColumn(code, 0, 127);
        this.designatedColumn = findRowOrColumn(code.substring(7), 0, 7);
    }

    private int findRowOrColumn(String code, int lower, int upper) {
        if (lower == upper) {
            return lower;
        }
        switch (code.charAt(0)) {
            case 'F':
            case 'L':
                return findRowOrColumn(code.substring(1), lower, ((upper + lower + 1) / 2) - 1);
            case 'B':
            case 'R':
                return findRowOrColumn(code.substring(1), ((upper + lower + 1) / 2), upper);
            default:
                throw new IllegalStateException();
        }
    }

    public Seat getSeat() {
        return new Seat(this.designatedRow, this.designatedColumn);
    }
}
