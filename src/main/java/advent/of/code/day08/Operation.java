package advent.of.code.day08;

public enum Operation {

    ACC {
        @Override
        void execute(Argument argument) {
            Accumulator.INSTANCE.acc(argument.getValue());
            InstructionRegistry.INSTANCE.acc();
        }
    },
    JMP {
        @Override
        void execute(Argument argument) {
            InstructionRegistry.INSTANCE.jmp(argument.getValue());
        }
    },
    NOP {
        @Override
        void execute(Argument argument) {
            InstructionRegistry.INSTANCE.nop();
        }
    },
    ;

    abstract void execute(Argument argument);
}
