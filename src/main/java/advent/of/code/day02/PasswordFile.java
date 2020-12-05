package advent.of.code.day02;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.io.Resources.getResource;
import static com.google.common.io.Resources.readLines;
import static java.nio.charset.StandardCharsets.UTF_8;

public class PasswordFile {
    private final List<PasswordWithPolicyLine> lines = new ArrayList<>();

    public PasswordFile(String file, PasswordPolicyStrategy strategy) throws Exception {
        readLines(getResource(file), UTF_8).stream()
                .map(String::trim)
                .map(l -> new PasswordWithPolicyLine(l, strategy)).forEach(this.lines::add);
    }

    public long validPasswordCount() {
        return this.lines.stream().filter(PasswordWithPolicyLine::isValid).count();
    }
}
