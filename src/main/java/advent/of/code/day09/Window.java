package advent.of.code.day09;

import java.util.ArrayList;
import java.util.List;

import io.vavr.collection.Stream;
import io.vavr.collection.Traversable;

import static java.lang.Integer.valueOf;

public class Window {
    private final List<Integer> numbers = new ArrayList<>();

    public Window(List<Integer> numbers) {
        this.numbers.addAll(numbers);
    }

    boolean hasSumFor(int number) {
        return Stream.ofAll(this.numbers)
                .combinations(2)
                .map(Traversable::sum)
                .contains(valueOf(number).longValue());

    }
}
