package advent.of.code.day07;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BagTest {

    @Test
    public void shouldCreateTree() {
        Bag bag1 = new Bag("1");
        Bag bag2 = new Bag("2");
        Bag bag3 = new Bag("3");
        Bag bag4 = new Bag("4");

        bag1.addChild(2, bag2);
        bag1.addChild(3, bag3);
        bag3.addChild(4, bag4);

        assertThat(bag1.countParents()).isEqualTo(0);
        assertThat(bag1.countChildren()).isEqualTo(2);
        assertThat(bag1.numberOfBagsFor("2")).isEqualTo(2);
        assertThat(bag1.numberOfBagsFor("4")).isEqualTo(0);
        assertThat(bag1.countChildBags()).isEqualTo(17);
        assertThat(bag2.countParents()).isEqualTo(1);
        assertThat(bag2.countChildren()).isEqualTo(0);
        assertThat(bag3.countParents()).isEqualTo(1);
        assertThat(bag3.countChildren()).isEqualTo(1);
    }
}
