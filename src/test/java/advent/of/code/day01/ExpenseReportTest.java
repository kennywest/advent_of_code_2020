package advent.of.code.day01;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ExpenseReportTest {

    @Test
    public void shouldFind2020Tuple() {
        ExpenseReport expenseReport = new ExpenseReport(
                1721,
                979,
                366,
                299,
                675,
                1456);

        var tuple = expenseReport.getTwentyTwentyTuple();

        assertThat(tuple).contains(new TwentyTwentyTuple(new ExpenseLine(1721), new ExpenseLine(299)));
        assertThat(tuple.get().multiplied()).isEqualTo(514579);
    }

    @Test
    public void shouldFind2020TupleInFile1() throws Exception {
        ExpenseReport expenseReport = new ExpenseReport("input_1_1.txt");

        var tuple = expenseReport.getTwentyTwentyTuple();

        assertThat(tuple).contains(new TwentyTwentyTuple(new ExpenseLine(1721), new ExpenseLine(299)));
        assertThat(tuple.get().multiplied()).isEqualTo(514579);
    }

    @Test
    public void shouldFind2020TupleInFile2() throws Exception {
        ExpenseReport expenseReport = new ExpenseReport("input_1_2.txt");

        var tuple = expenseReport.getTwentyTwentyTuple();

        assertThat(tuple).contains(new TwentyTwentyTuple(new ExpenseLine(1359), new ExpenseLine(661)));
        assertThat(tuple.get().multiplied()).isEqualTo(898299);
    }

    @Test
    public void shouldFind2020TripleInFile1() throws Exception {
        ExpenseReport expenseReport = new ExpenseReport("input_1_1.txt");

        var tuple = expenseReport.getTwentyTwentyTriple();

        assertThat(tuple).contains(new TwentyTwentyTriple(new ExpenseLine(979), new ExpenseLine(366), new ExpenseLine(675)));
        assertThat(tuple.get().multiplied()).isEqualTo(241861950);
    }

    @Test
    public void shouldFind2020TripleInFile2() throws Exception {
        ExpenseReport expenseReport = new ExpenseReport("input_1_2.txt");

        var tuple = expenseReport.getTwentyTwentyTriple();

        assertThat(tuple).contains(new TwentyTwentyTriple(new ExpenseLine(354), new ExpenseLine(1369), new ExpenseLine(297)));
        assertThat(tuple.get().multiplied()).isEqualTo(143933922);
    }
}
