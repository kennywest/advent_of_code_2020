package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.google.common.io.Resources.getResource;
import static com.google.common.io.Resources.readLines;
import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.Arrays.stream;

public class ExpenseReport {

    private final List<ExpenseLine> lines = new ArrayList<>();

    public ExpenseReport(int... expenses) {
        stream(expenses).mapToObj(ExpenseLine::new).forEach(lines::add);
    }

    public ExpenseReport(String file) throws Exception {
        readLines(getResource(file), UTF_8).stream()
                .map(String::trim)
                .map(Integer::parseInt)
                .map(ExpenseLine::new).forEach(lines::add);
    }

    public Optional<TwentyTwentyTuple> getTwentyTwentyTuple() {
        for (ExpenseLine line1 : lines) {
            for (ExpenseLine line2 : lines) {
                if (sumIsTwentyTwenty(line1, line2)) {
                    return Optional.of(new TwentyTwentyTuple(line1, line2));
                }
            }
        }
        return Optional.empty();
    }

    public Optional<TwentyTwentyTriple> getTwentyTwentyTriple() {
        for (ExpenseLine line1 : lines) {
            for (ExpenseLine line2 : lines) {
                for (ExpenseLine line3 : lines) {
                    if (sumIsTwentyTwenty(line1, line2, line3)) {
                        return Optional.of(new TwentyTwentyTriple(line1, line2, line3));
                    }
                }
            }
        }
        return Optional.empty();
    }

    private boolean sumIsTwentyTwenty(ExpenseLine line1, ExpenseLine line2) {
        return line1.getExpense() + line2.getExpense() == 2020;
    }

    private boolean sumIsTwentyTwenty(ExpenseLine line1, ExpenseLine line2, ExpenseLine line3) {
        return line1.getExpense() + line2.getExpense() + line3.getExpense() == 2020;
    }
}
