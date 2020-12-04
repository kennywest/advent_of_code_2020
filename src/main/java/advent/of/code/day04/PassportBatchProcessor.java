package advent.of.code.day04;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.io.Resources.getResource;
import static com.google.common.io.Resources.readLines;
import static java.nio.charset.StandardCharsets.UTF_8;

public class PassportBatchProcessor {

    private final List<PassportLine> lines = new ArrayList<>();

    public PassportBatchProcessor(String file) throws Exception {
        StringBuilder sb = new StringBuilder();

        for (String line : readLines(getResource(file), UTF_8)) {
            if (StringUtils.isEmpty(line)) {
                lines.add(new PassportLine(sb.toString()));
                sb = new StringBuilder();
            } else {
                sb.append(line).append(" ");
            }
        }

        lines.add(new PassportLine(sb.toString()));
    }

    public long muberOfValidPassports() {
        return this.lines.stream().filter(PassportLine::isValid).count();
    }

    public int numberOfPassportsInBatch() {
        return lines.size();
    }

    public PassportLine lastLine() {
        return this.lines.get(this.lines.size() - 1);
    }
}
