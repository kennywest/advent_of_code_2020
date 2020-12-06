package advent.of.code.day06;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.collect.Sets;
import lombok.Value;

import static java.util.stream.Collectors.toSet;
import static java.util.stream.IntStream.rangeClosed;

@Value
public class Group {

    List<FilledInForm> formsForGroup = new ArrayList<>();

    public void addFormWithAnswers(String answers) {
        this.formsForGroup.add(new FilledInForm(answers));
    }

    int countNumberOfAnswers() {
        return this.formsForGroup.stream()
                .flatMap(f -> f.getAnsweredYesTo().stream())
                .collect(toSet()).size();
    }

    int countCommonOfAnswers() {
        Set<Character> commonAnswers = rangeClosed('a', 'z').mapToObj(c -> (char) c).collect(toSet());

        for (Set<Character> answers : this.formsForGroup.stream().map(FilledInForm::getAnsweredYesTo).collect(Collectors.toSet())) {
            commonAnswers = Sets.intersection(commonAnswers, answers);
        }

        return commonAnswers.size();
    }
}
