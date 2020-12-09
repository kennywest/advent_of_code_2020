package advent.of.code.day09;

import java.util.ArrayList;
import java.util.List;

import io.vavr.collection.Stream;
import io.vavr.collection.Traversable;
import lombok.ToString;

import static java.util.Collections.unmodifiableList;

@ToString
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

    public Number sumOfAllValuesInWindow() {
        return Stream.ofAll(this.numbers).sum();
    }

    public List<Long> getNumbers() {
        return unmodifiableList(this.numbers);
    }

    public Long getLastNumber() {
        return this.numbers.get(this.numbers.size() - 1);
    }

    public Long getSmallestNumber() {
        return this.numbers.stream().min(Long::compare).orElse(0L);
    }

    public Long getBiggestNumber() {
        return this.numbers.stream().max(Long::compare).orElse(0L);
    }
}
