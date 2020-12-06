package advent.of.code.day06;

import java.util.Set;

import lombok.Value;

import static java.util.stream.Collectors.toSet;

@Value
public class FilledInForm {

    Set<Character> answeredYesTo;

    public FilledInForm(String answers) {
        this.answeredYesTo = answers.chars().mapToObj(c -> (char) c).collect(toSet());
    }
}
