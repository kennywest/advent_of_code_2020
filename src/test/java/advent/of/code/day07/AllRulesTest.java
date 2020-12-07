package advent.of.code.day07;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AllRulesTest {

    @Test
    public void shouldCountShinyGoldParents() throws Exception {
        BagRepository bagRepository = new BagRepository();

        new AllRules("input_7_1.txt", bagRepository);
        var bag = bagRepository.findBag("shiny gold");

        assertThat(bag).isNotEmpty();
        assertThat(bag).isNotEmpty();
        assertThat(bag.get().findAllParentBags().size()).isEqualTo(4);
    }

    @Test
    public void shouldCountShinyGoldParentsInPuzzle() throws Exception {
        BagRepository bagRepository = new BagRepository();

        new AllRules("input_7_2.txt", bagRepository);
        var bag = bagRepository.findBag("shiny gold");

        assertThat(bag).isNotEmpty();
        assertThat(bag).isNotEmpty();
        assertThat(bag.get().findAllParentBags().size()).isEqualTo(289);
    }
}
