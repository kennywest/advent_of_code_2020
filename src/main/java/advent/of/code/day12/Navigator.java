package advent.of.code.day12;

import java.util.List;

import static com.google.common.io.Resources.getResource;
import static com.google.common.io.Resources.readLines;
import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.stream.Collectors.toList;

public class Navigator {
    private List<NavigateAction> actions;

    public Navigator(String file) throws Exception {
        this.actions = readLines(getResource(file), UTF_8).stream().map(NavigateAction::new).collect(toList());
    }

    public void navigate() {
        this.actions.forEach(a -> {
            a.execute();
            a.execute2();
        });
    }
}
