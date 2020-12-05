package advent.of.code.day01;

import lombok.Value;

@Value
public class TwentyTwentyTuple {
    ExpenseLine line1;
    ExpenseLine line2;

    int multiplied() {
        return this.line1.getExpense() * this.line2.getExpense();
    }
}
