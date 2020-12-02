package advent.of.code.day02;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;
import static java.util.regex.Pattern.compile;

public class PasswordPolicy1 implements PasswordPolicy {
    private static final Pattern PATTERN = compile("([0-9]+)-([0-9]+).([a-zA-Z]{1})");

    private int atLeast;
    private int atMost;
    private String character;

    public PasswordPolicy1(String policy) {
        var matcher = PATTERN.matcher(policy.trim());
        if (matcher.matches()) {
            this.atLeast = parseInt(matcher.group(1));
            this.atMost = parseInt(matcher.group(2));
            this.character = matcher.group(3);
        }
    }

    public int getAtLeast() {
        return atLeast;
    }

    public int getAtMost() {
        return atMost;
    }

    public String getCharacter() {
        return character;
    }

    @Override
    public boolean isValid(String password) {
        int count = StringUtils.countMatches(password, this.character);
        return count >= this.atLeast && count <= this.atMost;
    }
}
