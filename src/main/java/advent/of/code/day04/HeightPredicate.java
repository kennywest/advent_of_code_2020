package advent.of.code.day04;

import org.apache.commons.lang3.StringUtils;

import java.util.function.Predicate;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class HeightPredicate implements Predicate<String> {
    private static final Pattern PATTERN = Pattern.compile("([0-9]+)(cm|in)");

    @Override
    public boolean test(String s) {
        if (StringUtils.isBlank(s)) {
            return false;
        }

        var matcher = PATTERN.matcher(s);
        if (matcher.matches()) {
            int height = parseInt(matcher.group(1));
            String uom = matcher.group(2);
            switch (uom) {
                case "in":
                    return height >= 59 && height <= 76;
                case "cm":
                    return height >= 150 && height <= 193;
                default:
                    return false;
            }
        }

        return false;
    }
}
