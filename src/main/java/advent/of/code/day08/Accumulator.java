package advent.of.code.day08;

import java.util.concurrent.atomic.AtomicInteger;

public class Accumulator {

    public static final Accumulator INSTANCE = new Accumulator();

    private final AtomicInteger currentValue = new AtomicInteger();

    public int acc(int value) {
        return this.currentValue.accumulateAndGet(value, Integer::sum);
    }

    public int getCurrentValue() {
        return this.currentValue.intValue();
    }

    public void reset() {
        this.currentValue.set(0);
    }
}
