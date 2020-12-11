package advent.of.code.day11;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.io.Resources.getResource;
import static com.google.common.io.Resources.readLines;
import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.stream.Collectors.toList;

public class Grid {

    private final List<List<Character>> positions = new ArrayList<>();

    public Grid(List<String> lines) {
        lines.forEach(line -> this.positions.add(line.chars().mapToObj(c -> (char) c).collect(toList())));
    }

    public Grid(String file) throws Exception {
        this(readLines(getResource(file), UTF_8).stream().collect(toList()));
    }

    public List<Seat> getListOfSeats() {
        List<Seat> seats = new ArrayList<>();
        for (int i = 0; i < this.positions.size(); i++) {
            List<Character> row = this.positions.get(i);
            for (int j = 0; j < row.size(); j++) {
                if (row.get(j) == 'L') {
                    seats.add(new Seat(j, i));
                }
            }
        }

        return seats;
    }
}
