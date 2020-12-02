package advent.of.code.day02;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.io.Resources.getResource;
import static com.google.common.io.Resources.readLines;
import static java.nio.charset.StandardCharsets.UTF_8;

public class PasswordFile {
    private final List<PaswordWithPolicyLine> lines = new ArrayList<>();

    public PasswordFile(String file, PasswordPolicyStrategy strategy) throws Exception {
        readLines(getResource(file), UTF_8).stream()
                .map(String::trim)
                .map(l -> new PaswordWithPolicyLine(l, strategy)).forEach(lines::add);
    }

    public long validPasswordCount() {
        return lines.stream().filter(PaswordWithPolicyLine::isValid).count();
    }
}
