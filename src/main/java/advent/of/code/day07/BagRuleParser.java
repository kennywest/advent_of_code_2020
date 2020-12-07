package advent.of.code.day07;

import static java.lang.Integer.parseInt;
import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.isNumeric;

public class BagRuleParser {
    private final BagRuleListener bagRuleListener;

    public BagRuleParser(BagRuleListener bagRuleListener) {
        this.bagRuleListener = bagRuleListener;
    }

    public void parse(String line) {
        String[] parts = line.split(" ");
        parse(parts, 0);
    }

    private void parse(String[] parts, int currentIndex) {
        StringBuilder sb = new StringBuilder();
        if (isNumeric(parts[currentIndex])) {
            this.bagRuleListener.count(parseInt(parts[currentIndex]));
            currentIndex++;
        }

        while (!parts[currentIndex].contains("bag")) {
            sb.append(parts[currentIndex++]).append(" ");
        }

        String bagColor = sb.toString();
        if (!bagColor.contains("no other")) {
            this.bagRuleListener.bagWithColor(bagColor);
        }

        if (asList("bag", "bags").contains(parts[currentIndex])) {
            currentIndex++;
        }

        if (asList("bag,", "bags,").contains(parts[currentIndex])) {
            this.bagRuleListener.and();
            parse(parts, currentIndex + 1);
        }

        if (asList("bag.", "bags.").contains(parts[currentIndex])) {
            this.bagRuleListener.period();
        }

        if (parts[currentIndex].contains("contain")) {
            this.bagRuleListener.contains();
            parse(parts, currentIndex + 1);
        }
    }
}
