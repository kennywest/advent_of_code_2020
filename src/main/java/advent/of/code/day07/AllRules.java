package advent.of.code.day07;

import static com.google.common.io.Resources.getResource;
import static com.google.common.io.Resources.readLines;
import static java.nio.charset.StandardCharsets.UTF_8;

public class AllRules {

    public AllRules(String file, BagRepository bagRepository) throws Exception {
        readLines(getResource(file), UTF_8).forEach(l -> new BagRuleParser(new BagRuleListener(bagRepository)).parse(l));
    }
}
