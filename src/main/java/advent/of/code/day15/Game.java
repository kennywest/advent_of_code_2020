package advent.of.code.day15;

import java.util.HashMap;
import java.util.Map;

import io.vavr.Tuple;
import io.vavr.Tuple2;

public class Game {
    //private final List<Integer> numbersSpoken = new ArrayList<>();
    private final Map<Integer, Tuple2<Integer, Integer>> numbersSpoken = new HashMap<>();
    private int lastNumberSpoken;
    private int currentTurn;

    public Game(int... startingNumbers) {
        this.currentTurn = 1;
        for (int startingNumber : startingNumbers) {
            this.numbersSpoken.put(startingNumber, Tuple.of(this.currentTurn++, null));
            this.lastNumberSpoken = startingNumber;
        }
    }

    public void tic() {
        if (isFirstTimeSpoken(this.lastNumberSpoken)) {
            addOrUpdateNumbersSpoken(0);
        } else {
            Tuple2<Integer, Integer> turnsForLastSpokenNumber = getTurnsForLastSpokenNumber(this.lastNumberSpoken);
            addOrUpdateNumbersSpoken(turnsForLastSpokenNumber._1 - turnsForLastSpokenNumber._2);
        }
    }

    private void addOrUpdateNumbersSpoken(Integer numberSpoken) {
        var numberSpokenInTurns = this.numbersSpoken.get(numberSpoken);

        if (numberSpokenInTurns == null) {
            this.numbersSpoken.put(numberSpoken, Tuple.of(this.currentTurn++, null));
        } else {
            this.numbersSpoken.put(numberSpoken, Tuple.of(this.currentTurn++, numberSpokenInTurns._1));
        }
        this.lastNumberSpoken = numberSpoken;
    }

    public int getCurrentTurn() {
        return this.currentTurn;
    }

    public int getLastTurn() {
        return this.currentTurn - 1;
    }

    public int getLastNumberSpoken() {
        return this.lastNumberSpoken;
    }

    private boolean isFirstTimeSpoken(int number) {
        return this.numbersSpoken.get(number)._2 == null;
    }

    private Tuple2<Integer, Integer> getTurnsForLastSpokenNumber(int number) {
        return this.numbersSpoken.get(number);
    }
}
