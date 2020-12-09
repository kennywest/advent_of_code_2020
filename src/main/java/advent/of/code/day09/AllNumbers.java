package advent.of.code.day09;

import java.util.ArrayList;
import java.util.List;

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
        try {
            return new HasValidInWindow(
                    new Window(this.allNumbers.subList(this.currentWindowStartsAt, this.currentWindowStartsAt + windowSize)),
                    this.allNumbers.get(this.currentWindowStartsAt + windowSize));
        } finally {
            this.currentWindowStartsAt++;
        }
    }

    public int size() {
        return this.allNumbers.size();
    }

    @Value
    static class HasValidInWindow {
        Window window;
        long testValue;

        public boolean test() {
            return this.window.hasSumFor(this.testValue);
        }

        public List<Long> getNumbers() {
            return this.window.getNumbers();
        }

        public long getTestValue() {
            return this.testValue;
        }
    }
}
