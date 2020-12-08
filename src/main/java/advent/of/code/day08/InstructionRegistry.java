package advent.of.code.day08;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import io.vavr.Tuple2;

public class InstructionRegistry {

    public static final InstructionRegistry INSTANCE = new InstructionRegistry();

    private final List<Tuple2<Integer, Instruction>> instructions = new ArrayList<>();
    private Tuple2<Integer, Instruction> currentInstruction;
    private final Set<Integer> instructionsExecuted = new HashSet<>();
    private boolean ended;

    public void register(Instruction instruction) {
        Tuple2<Integer, Instruction> toAdd = new Tuple2<>(this.instructions.size(), instruction);
        if (this.currentInstruction == null) {
            this.currentInstruction = toAdd;
        }
        this.instructions.add(toAdd);
    }

    public void tic() {
        if (this.instructionsExecuted.contains(this.currentInstruction._1)) {
            Tuple2<Integer, Instruction> last = this.instructionsExecuted.stream().max(Integer::compareTo).map(this.instructions::get).orElse(null);
            throw new RuntimeException("infinite loop detected, got at " + last);
        }
        this.instructionsExecuted.add(this.currentInstruction._1);
        this.currentInstruction._2.execute();
    }

    public void acc() {
        jmp(1);
    }

    public void nop() {
        jmp(1);
    }

    public void jmp(int value) {
        if (this.currentInstruction == null) {
            this.ended = true;
            return;
        }

        int next = this.currentInstruction._1 + value;
        if (this.instructions.size() <= next) {
            this.ended = true;
            return;
        }
        this.currentInstruction = this.instructions.get(this.currentInstruction._1 + value);
    }

    public boolean hasEnded() {
        return this.ended;
    }

    public void clear() {
        this.ended = false;
        this.instructions.clear();
        this.currentInstruction = null;
        this.instructionsExecuted.clear();
    }

    public void reset() {
        this.ended = false;
        this.currentInstruction = this.instructions.get(0);
        this.instructionsExecuted.clear();
    }
}
