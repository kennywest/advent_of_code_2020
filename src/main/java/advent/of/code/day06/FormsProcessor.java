package advent.of.code.day06;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.io.Resources.getResource;
import static com.google.common.io.Resources.readLines;
import static java.nio.charset.StandardCharsets.UTF_8;
import static org.apache.commons.lang3.StringUtils.isEmpty;

public class FormsProcessor {

    private final List<Group> groups = new ArrayList<>();

    public FormsProcessor(String file) throws Exception {
        Group group = new Group();

        for (String answers : readLines(getResource(file), UTF_8)) {
            if (!isEmpty(answers)) {
                group.addFormWithAnswers(answers);
            } else {
                this.groups.add(group);
                group = new Group();
            }
        }

        this.groups.add(group);
    }

    public List<Group> getGroups() {
        return this.groups;
    }

    public int sumNumberOfAnswers() {
        return this.groups.stream().map(Group::countNumberOfAnswers).reduce(0, Integer::sum);
    }

    public int sumCommonAnswers() {
        return this.groups.stream().map(Group::countCommonOfAnswers).reduce(0, Integer::sum);
    }
}
