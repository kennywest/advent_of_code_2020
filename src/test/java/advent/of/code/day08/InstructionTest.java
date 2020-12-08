package advent.of.code.day08;

import org.junit.Before;
import org.junit.Test;

import static advent.of.code.day08.Operation.ACC;
import static org.assertj.core.api.Assertions.assertThat;

public class InstructionTest {

    @Before
    public void setUp() {
        Accumulator.INSTANCE.reset();
        InstructionRegistry.INSTANCE.clear();
    }

    @Test
    public void shouldParseInstruction() {
        var instruction = new Instruction("acc -99");

        assertThat(instruction.getOperation()).isEqualTo(ACC);
        assertThat(instruction.getArgument().getValue()).isEqualTo(-99);
    }

    @Test
    public void shouldExecuteAcc() {
        var instruction = new Instruction("acc -99");

        instruction.execute();

        assertThat(Accumulator.INSTANCE.getCurrentValue()).isEqualTo(-99);
    }
}
