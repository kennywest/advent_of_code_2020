package advent.of.code.day11;

import java.util.ArrayList;
import java.util.List;

import static advent.of.code.day11.Seat.State.OCCUPIED;
import static com.google.common.io.Resources.getResource;
import static com.google.common.io.Resources.readLines;
import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.stream.Collectors.toList;

public class Grid {

    private final List<List<Character>> positions = new ArrayList<>();
    private final SurroundingSeatsSpotter spotter;

    public Grid(List<String> lines) {
        this(lines, new SurroundingSeatsSpotter.Easy());
    }

    public Grid(List<String> lines, SurroundingSeatsSpotter spotter) {
        this.spotter = spotter;
        lines.forEach(line -> this.positions.add(line.chars().mapToObj(c -> (char) c).collect(toList())));
    }

    public Grid(String file) throws Exception {
        this(readLines(getResource(file), UTF_8).stream().collect(toList()));
    }

    public Grid(String file, SurroundingSeatsSpotter spotter) throws Exception {
        this(readLines(getResource(file), UTF_8).stream().collect(toList()), spotter);
    }

    public List<Seat> getListOfSeats() {
        List<Seat> seats = new ArrayList<>();
        for (int y = 0; y < this.positions.size(); y++) {
            List<Character> row = this.positions.get(y);
            for (int x = 0; x < row.size(); x++) {
                if (row.get(x) == 'L') {
                    seats.add(new Seat(x, y, this.spotter));
                }
                if (row.get(x) == '#') {
                    seats.add(new Seat(x, y, this.spotter, OCCUPIED));
                }
            }
        }

        return seats;
    }
}
