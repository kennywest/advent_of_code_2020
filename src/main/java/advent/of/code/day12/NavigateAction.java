package advent.of.code.day12;

import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

@lombok.Value
public class NavigateAction {
    private static final Pattern PATTERN = Pattern.compile("([A-Z])([0-9]+)");

    Action action;
    Value value;

    public NavigateAction(String action) {
        var matcher = PATTERN.matcher(action.trim());
        if (matcher.matches()) {
            this.action = Action.valueOf(matcher.group(1));
            this.value = new Value(parseInt(matcher.group(2)));
        } else {
            throw new IllegalStateException(String.format("cannot parse %s", action));
        }
    }

    public void execute() {
        this.action.execute(this.value);
    }

    public void execute2() {
        this.action.execute2(this.value);
    }
}
