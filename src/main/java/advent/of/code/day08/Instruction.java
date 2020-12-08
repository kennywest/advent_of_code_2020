package advent.of.code.day08;

import lombok.Value;

@Value
public class Instruction {

    Operation operation;
    Argument argument;

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
}
