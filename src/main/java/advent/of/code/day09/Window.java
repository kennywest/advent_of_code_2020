package advent.of.code.day09;

import java.util.ArrayList;
import java.util.List;

import io.vavr.collection.Stream;
import io.vavr.collection.Traversable;

import static java.util.Collections.unmodifiableList;

public class Window {
    private final List<Long> numbers = new ArrayList<>();

    public Window(List<Long> numbers) {
        this.numbers.addAll(numbers);
    }

    boolean hasSumFor(long number) {
        return Stream.ofAll(this.numbers)
                .combinations(2)
                .map(Traversable::sum)
                .contains(number);
    }

    public List<Long> getNumbers() {
        return unmodifiableList(this.numbers);
    }
}
