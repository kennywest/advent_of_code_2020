package advent.of.code.day05;

import lombok.Value;

import static java.lang.Integer.compare;

@Value
public class Seat implements Comparable<Seat> {
    int row;
    int column;

    public int getSeatId() {
        return this.row * 8 + this.column;
    }

    @Override
    public int compareTo(Seat o) {
        return compare(this.getSeatId(), o.getSeatId());
    }
}
