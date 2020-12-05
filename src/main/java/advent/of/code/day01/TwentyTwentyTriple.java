package advent.of.code.day01;

import lombok.Value;

@Value
public class TwentyTwentyTriple {
    ExpenseLine line1;
    ExpenseLine line2;
    ExpenseLine line3;

    int multiplied() {
        return this.line1.getExpense() * this.line2.getExpense() * this.line3.getExpense();
    }
}
