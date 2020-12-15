package advent.of.code.day15;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    @Test
    public void shouldSolveGame1() {
        var game = new Game(0, 3, 6);

        while (game.getLastTurn() != 2020) {
            game.tic();
        }

        assertThat(game.getLastNumberSpoken()).isEqualTo(436);
    }

    @Test
    public void shouldSolveGame2() {
        var game = new Game(1, 3, 2);

        while (game.getLastTurn() != 2020) {
            game.tic();
        }

        assertThat(game.getLastNumberSpoken()).isEqualTo(1);
    }

    @Test
    public void shouldSolveGame3() {
        var game = new Game(2, 1, 3);

        while (game.getLastTurn() != 2020) {
            game.tic();
        }

        assertThat(game.getLastNumberSpoken()).isEqualTo(10);
    }

    @Test
    public void shouldSolvePuzzleInput() {
        var game = new Game(19, 0, 5, 1, 10, 13);

        while (game.getLastTurn() != 2020) {
            game.tic();
        }

        assertThat(game.getLastNumberSpoken()).isEqualTo(1015);
    }

    @Test
    public void shouldSolvePuzzleInputBonus() {
        var game = new Game(19, 0, 5, 1, 10, 13);

        while (game.getLastTurn() != 30_000_000) {
            game.tic();
        }

        assertThat(game.getLastNumberSpoken()).isEqualTo(201);
    }
}
