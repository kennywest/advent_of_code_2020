package advent.of.code.day11;

public class ChangedStateListener {

    private boolean stateChanged = false;


    public boolean isStateChanged() {
        return this.stateChanged;
    }

    public void recordChange() {
        this.stateChanged = true;
    }
}
