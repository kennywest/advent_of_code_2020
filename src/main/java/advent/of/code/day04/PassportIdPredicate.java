package advent.of.code.day04;

import java.util.function.Predicate;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class PassportIdPredicate implements Predicate<String> {
    private static final Pattern PATTERN = Pattern.compile("[0-9]{9}");

    @Override
    public boolean test(String s) {
        if (StringUtils.isBlank(s)) {
            return false;
        }

        var matcher = PATTERN.matcher(s);
        return matcher.matches();
    }
}
