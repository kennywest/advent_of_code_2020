package advent.of.code.day07;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BagRuleParserTest {

    @Test
    public void shouldParseLineWithChildren() {
        BagRepository bagRepository = new BagRepository();
        new BagRuleParser(new BagRuleListener(bagRepository)).parse("light red bags contain 1 bright white bag, 2 muted yellow bags.");

        assertThat(bagRepository.findBag("light red")).contains(new Bag("light red"));
        assertThat(bagRepository.findBag("light red").get().countParents()).isEqualTo(0);
        assertThat(bagRepository.findBag("bright white")).contains(new Bag("bright white"));
        assertThat(bagRepository.findBag("bright white").get().countParents()).isEqualTo(1);
        assertThat(bagRepository.findBag("bright white").get().countChildren()).isEqualTo(0);
        assertThat(bagRepository.findBag("muted yellow")).contains(new Bag("muted yellow"));
        assertThat(bagRepository.findBag("muted yellow").get().countParents()).isEqualTo(1);
        assertThat(bagRepository.findBag("muted yellow").get().countChildren()).isEqualTo(0);
    }

    @Test
    public void shouldParseLineWithoutChildren() {
        BagRepository bagRepository = new BagRepository();
        new BagRuleParser(new BagRuleListener(bagRepository)).parse("faded blue bags contain no other bags.");

        assertThat(bagRepository.findBag("faded blue")).contains(new Bag("faded blue"));
        assertThat(bagRepository.findBag("faded blue").get().countParents()).isEqualTo(0);
        assertThat(bagRepository.findBag("faded blue").get().countChildren()).isEqualTo(0);
    }
}
