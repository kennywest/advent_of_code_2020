package org.example;

import lombok.Value;

@Value
public class TwentyTwentyTriple {
    ExpenseLine line1;
    ExpenseLine line2;
    ExpenseLine line3;

    int multiplied() {
        return line1.getExpense() * line2.getExpense() * line3.getExpense();
    }
}
