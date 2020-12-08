package advent.of.code.day08;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import static advent.of.code.day08.Operation.JMP;
import static advent.of.code.day08.Operation.NOP;

@ToString
@EqualsAndHashCode
public class Instruction {

    private Operation operation;
    private final Argument argument;

    public Instruction(String line) {
        String[] parts = line.split(" ");

        this.operation = Operation.valueOf(parts[0].toUpperCase());

        if (parts.length > 1) {
            this.argument = new Argument(Integer.parseInt(parts[1]));
        } else {
            this.argument = null;
        }
    }

    void execute() {
        this.operation.execute(this.argument);
    }

    public Operation getOperation() {
        return this.operation;
    }

    void switchOperation() {
        switch (this.operation) {
            case JMP:
                this.operation = NOP;
                break;
            case NOP:
                this.operation = JMP;
                break;
        }
    }

    public Argument getArgument() {
        return this.argument;
    }
}
