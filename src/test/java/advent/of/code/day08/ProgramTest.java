package advent.of.code.day08;

import org.junit.Before;
import org.junit.Test;

import static advent.of.code.day08.Operation.JMP;
import static advent.of.code.day08.Operation.NOP;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ProgramTest {

    @Before
    public void setUp() {
        Accumulator.INSTANCE.reset();
        InstructionRegistry.INSTANCE.clear();
    }

    @Test
    public void shouldRunProgramAndThrowException() throws Exception {
        var program = new Program("input_8_1.txt");

        assertThatExceptionOfType(RuntimeException.class).isThrownBy(program::run)
                .withMessage("infinite loop detected, got at (7, Instruction(operation=JMP, argument=Argument(value=-4)))");
        assertThat(Accumulator.INSTANCE.getCurrentValue()).isEqualTo(5);
    }

    @Test
    public void shouldRunProgramAndEnd() throws Exception {
        var program = new Program("input_8_3.txt");

        program.run();

        assertThat(Accumulator.INSTANCE.getCurrentValue()).isEqualTo(8);
    }

    @Test
    public void shouldRunProgramFromPuzzleAndThrowException() throws Exception {
        var program = new Program("input_8_2.txt");

        assertThatExceptionOfType(RuntimeException.class).isThrownBy(program::run)
                .withMessage("infinite loop detected, got at (609, Instruction(operation=JMP, argument=Argument(value=-521)))");
        assertThat(Accumulator.INSTANCE.getCurrentValue()).isEqualTo(1709);
    }

    @Test
    public void shouldRunPuzzleInputAndEnd() throws Exception {
        var program = new Program("input_8_2.txt");
        var instructions = InstructionRegistry.INSTANCE.getAllInstructions(i -> JMP == i.getOperation() || NOP == i.getOperation());

        for (int i = 0; i < instructions.size(); i++) {
            try {
                program.run();
            } catch (Throwable t) {
                if (i > 0) {
                    instructions.get(i - 1).switchOperation();
                }
                instructions.get(i).switchOperation();
                program.reset();
            }
        }

        assertThat(Accumulator.INSTANCE.getCurrentValue()).isEqualTo(1976);
    }
}
