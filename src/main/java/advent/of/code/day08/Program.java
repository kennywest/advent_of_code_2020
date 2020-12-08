package advent.of.code.day08;

import static com.google.common.io.Resources.getResource;
import static com.google.common.io.Resources.readLines;
import static java.nio.charset.StandardCharsets.UTF_8;

public class Program {

    Program(String file) throws Exception {
        readLines(getResource(file), UTF_8).forEach(l -> InstructionRegistry.INSTANCE.register(new Instruction(l)));
    }

    public void run() {
        while (!InstructionRegistry.INSTANCE.hasEnded()) {
            InstructionRegistry.INSTANCE.tic();
        }
    }
}
