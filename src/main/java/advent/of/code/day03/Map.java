package advent.of.code.day03;

import java.util.List;

import static com.google.common.io.Resources.getResource;
import static com.google.common.io.Resources.readLines;
import static java.nio.charset.StandardCharsets.UTF_8;

public class Map {

    private RowOnMap start;
    private RowOnMap end;

    public Map(String file) throws Exception {
        List<String> lines = readLines(getResource(file), UTF_8);
        this.start = new RowOnMap(lines.get(0), 0);
        this.end = this.start;
        for (int i = 1; i < lines.size(); i++) {
            this.end = this.end.next(lines.get(i));
        }
    }

    public RowOnMap getStart()   {
        return this.start;
    }

    public RowOnMap getEnd() {
        return this.end;
    }
}
