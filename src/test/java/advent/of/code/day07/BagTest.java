package advent.of.code.day07;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BagTest {

    @Test
    public void shouldCreateTree() {
        Bag bag1 = new Bag("1");
        Bag bag2 = new Bag("2");
        Bag bag3 = new Bag("3");

        bag1.addChild(bag2);
        bag1.addChild(bag3);

        assertThat(bag1.countParents()).isEqualTo(0);
        assertThat(bag1.countChildren()).isEqualTo(2);
        assertThat(bag2.countParents()).isEqualTo(1);
        assertThat(bag2.countChildren()).isEqualTo(0);
        assertThat(bag3.countParents()).isEqualTo(1);
        assertThat(bag3.countChildren()).isEqualTo(0);
    }
}
