package advent.of.code.day02;

import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;
import static java.util.regex.Pattern.compile;

public class PasswordPolicy2 implements PasswordPolicy {
    private static final Pattern PATTERN = compile("([0-9]+)-([0-9]+).([a-zA-Z]{1})");

    private int position1;
    private int position2;
    private char character;

    public PasswordPolicy2(String policy) {
        var matcher = PATTERN.matcher(policy.trim());
        if (matcher.matches()) {
            this.position1 = parseInt(matcher.group(1));
            this.position2 = parseInt(matcher.group(2));
            this.character = matcher.group(3).charAt(0);
        }
    }

    @Override
    public boolean isValid(String password) {
        boolean position1HasCorrectCharacter = password.charAt(this.position1 - 1) == this.character;
        boolean position2HasCorrectCharacter = password.charAt(this.position2 - 1) == this.character;
        if (position1HasCorrectCharacter) {
            return !position2HasCorrectCharacter;
        } else {
            return position2HasCorrectCharacter;
        }
    }
}
