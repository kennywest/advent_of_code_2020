package advent.of.code.day04;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.Arrays.stream;

public class PassportLine {
    private static final String BIRTH_YEAR = "byr";
    private static final String ISSUE_YEAR = "iyr";
    private static final String EXPIRATION_YEAR = "eyr";
    private static final String HEIGHT = "hgt";
    private static final String HAIR_COLOR = "hcl";
    private static final String EYE_COLOR = "ecl";
    private static final String PASSPORT_ID = "pid";
    private static final String COUNTRY_ID = "cid";
    private static final List<String> ALL_KEYS = List.of(BIRTH_YEAR, ISSUE_YEAR, EXPIRATION_YEAR, HEIGHT, HAIR_COLOR, EYE_COLOR, PASSPORT_ID, COUNTRY_ID);
    private static final List<String> ALL_KEYS_BUT_CID = List.of(BIRTH_YEAR, ISSUE_YEAR, EXPIRATION_YEAR, HEIGHT, HAIR_COLOR, EYE_COLOR, PASSPORT_ID);

    private final Map<String, String> data = new HashMap<>();

    public PassportLine(String line) {
        stream(line.split("\\s")).forEach(d -> {
            String[] dataParts = d.split(":");
            data.put(dataParts[0], dataParts[1]);
        });
    }

    public boolean isValid() {
        return ALL_KEYS_BUT_CID.stream().allMatch(data::containsKey);
    }

    public Optional<Integer> getBirthYear() {
        return Optional.ofNullable(data.get(BIRTH_YEAR)).map(Integer::parseInt);
    }

    public Optional<Integer> getIssueYear() {
        return Optional.ofNullable(data.get(ISSUE_YEAR)).map(Integer::parseInt);
    }
}
