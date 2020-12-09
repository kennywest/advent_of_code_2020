package advent.of.code.day09;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

import lombok.Value;

import static com.google.common.io.Resources.getResource;
import static com.google.common.io.Resources.readLines;
import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.stream.Collectors.toList;

public class AllNumbers {
    private final List<Long> allNumbers = new ArrayList<>();
    private int currentWindowStartsAt = 0;

    public AllNumbers(List<Long> allNumbers) {
        this.allNumbers.addAll(allNumbers);
    }

    public AllNumbers(String file) throws Exception {
        this(readLines(getResource(file), UTF_8).stream().map(Long::parseLong).collect(toList()));
    }

    public HasValidInWindow checkNext(int windowSize) {
        return checkNext(windowSize, this.allNumbers.get(this.currentWindowStartsAt + windowSize));
    }

    public HasValidInWindow checkNext(int windowSize, long testValue) {
        try {
            return new HasValidInWindow(
                    new Window(this.allNumbers.subList(this.currentWindowStartsAt, this.currentWindowStartsAt + windowSize)),
                    testValue);
        } finally {
            this.currentWindowStartsAt++;
        }
    }

    public Window findWindowHavindSum(long sum) {
        BiFunction<Window, Long, Boolean> sumOfAllValuesInWindowEquals = (w, l) -> w.sumOfAllValuesInWindow().equals(l);

        for (int i = 2; i < this.allNumbers.size(); i++) {
            this.currentWindowStartsAt = 0;
            var window = checkNext(i, sum);
            while (window.getLastNumber() != sum) {
                if (window.test(sumOfAllValuesInWindowEquals)) {
                    return window.window;
                }
                window = checkNext(i, sum);
            }
        }

        return null;
    }

    public int size() {
        return this.allNumbers.size();
    }

    @Value
    static class HasValidInWindow {
        Window window;
        long testValue;

        public boolean test(BiFunction<Window, Long, Boolean> predicate) {
            return predicate.apply(this.window, this.testValue);
        }

        public List<Long> getNumbers() {
            return this.window.getNumbers();
        }

        public long getTestValue() {
            return this.testValue;
        }

        public long getLastNumber() {
            return this.window.getLastNumber();
        }
    }
}
