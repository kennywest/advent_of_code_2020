package advent.of.code.day08;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class InstructionRegistryTest {

    @Before
    public void setUp() {
        Accumulator.INSTANCE.reset();
        InstructionRegistry.INSTANCE.clear();
    }

    @Test
    public void shouldExecuteInstruction() {
        InstructionRegistry.INSTANCE.register(new Instruction("nop"));

        InstructionRegistry.INSTANCE.tic();

        assertThat(InstructionRegistry.INSTANCE.hasEnded()).isTrue();
    }

    @Test
    public void shouldExecuteInstructions() {
        InstructionRegistry.INSTANCE.register(new Instruction("nop"));
        InstructionRegistry.INSTANCE.register(new Instruction("acc +3"));
        InstructionRegistry.INSTANCE.register(new Instruction("acc -2"));

        InstructionRegistry.INSTANCE.tic();
        InstructionRegistry.INSTANCE.tic();
        InstructionRegistry.INSTANCE.tic();

        assertThat(Accumulator.INSTANCE.getCurrentValue()).isEqualTo(1);
        assertThat(InstructionRegistry.INSTANCE.hasEnded()).isTrue();
    }

    @Test
    public void shouldExecuteInstructionsWithJmp() {
        InstructionRegistry.INSTANCE.register(new Instruction("nop"));
        InstructionRegistry.INSTANCE.register(new Instruction("jmp +4"));
        InstructionRegistry.INSTANCE.register(new Instruction("acc +1"));
        InstructionRegistry.INSTANCE.register(new Instruction("acc +2"));
        InstructionRegistry.INSTANCE.register(new Instruction("acc +3"));
        InstructionRegistry.INSTANCE.register(new Instruction("acc +4"));

        InstructionRegistry.INSTANCE.tic();
        InstructionRegistry.INSTANCE.tic();
        InstructionRegistry.INSTANCE.tic();

        assertThat(Accumulator.INSTANCE.getCurrentValue()).isEqualTo(4);
        assertThat(InstructionRegistry.INSTANCE.hasEnded()).isTrue();
    }
}
