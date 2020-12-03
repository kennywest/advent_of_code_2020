package advent.of.code.day03;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NavigatorOnMapTest {

    @Test
    public void shouldNavigate() throws Exception {
        Map map = new Map("input_3_1.txt");
        NavigatorOnMap navigator = new NavigatorOnMap(map);

        RowOnMap.Cell cell = navigator.navigateToNextCell();

        assertThat(cell.x).isEqualTo(3);
        assertThat(cell.y).isEqualTo(1);
    }

    @Test
    public void shouldCountTrees() throws Exception {
        Map map = new Map("input_3_1.txt");
        NavigatorOnMap navigator = new NavigatorOnMap(map);

        assertThat(navigator.countNumberOfTreesOnPath(3, 1)).isEqualTo(7);
    }

    @Test
    public void shouldCountTreesOnDifferentPaths() throws Exception {
        Map map = new Map("input_3_1.txt");
        NavigatorOnMap navigator = new NavigatorOnMap(map);

        assertThat(navigator.countNumberOfTreesOnPath(1, 1)).isEqualTo(2);
        assertThat(navigator.countNumberOfTreesOnPath(3, 1)).isEqualTo(7);
        assertThat(navigator.countNumberOfTreesOnPath(5, 1)).isEqualTo(3);
        assertThat(navigator.countNumberOfTreesOnPath(7, 1)).isEqualTo(4);
        assertThat(navigator.countNumberOfTreesOnPath(1, 2)).isEqualTo(2);
    }

    @Test
    public void shouldCountTreesOnPuzzle() throws Exception {
        Map map = new Map("input_3_2.txt");
        NavigatorOnMap navigator = new NavigatorOnMap(map);

        assertThat(navigator.countNumberOfTreesOnPath(3, 1)).isEqualTo(242);
    }

    @Test
    public void shouldCountTreesOnDifferentPathsOfPuzzle() throws Exception {
        Map map = new Map("input_3_2.txt");
        NavigatorOnMap navigator = new NavigatorOnMap(map);

        assertThat(navigator.countNumberOfTreesOnPath(1, 1)).isEqualTo(82);
        assertThat(navigator.countNumberOfTreesOnPath(3, 1)).isEqualTo(242);
        assertThat(navigator.countNumberOfTreesOnPath(5, 1)).isEqualTo(71);
        assertThat(navigator.countNumberOfTreesOnPath(7, 1)).isEqualTo(67);
        assertThat(navigator.countNumberOfTreesOnPath(1, 2)).isEqualTo(24);
    }
}
