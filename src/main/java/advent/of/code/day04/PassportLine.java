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
    private static final HeightPredicate HEIGHT_PREDICATE = new HeightPredicate();
    private static final HairColorPredicate HAIR_COLOR_PREDICATE = new HairColorPredicate();
    private static final PassportIdPredicate PASSPORT_ID_PREDICATE = new PassportIdPredicate();

    private final Map<String, String> data = new HashMap<>();

    public PassportLine(String line) {
        stream(line.split("\\s")).forEach(d -> {
            String[] dataParts = d.split(":");
            data.put(dataParts[0], dataParts[1]);
        });
    }

    public boolean isValid() {
        boolean valid = ALL_KEYS_BUT_CID.stream().allMatch(data::containsKey);

        valid = valid && validBirthYear()
                && validIssueYear()
                && validExpirationYear()
                && validHeight()
                && validHairColor()
                && validEyeColor()
                && validPassportId();

        return valid;
    }

    private boolean validBirthYear() {
        return getBirthYear().filter(p -> p >= 1920 && p <= 2002).isPresent();
    }

    private boolean validIssueYear() {
        return getIssueYear().filter(p -> p >= 2010 && p <= 2020).isPresent();
    }

    private boolean validExpirationYear() {
        return getExpirationYear().filter(p -> p >= 2020 && p <= 2030).isPresent();
    }

    private boolean validHeight() {
        return HEIGHT_PREDICATE.test(data.get(HEIGHT));
    }

    private boolean validHairColor() {
        return HAIR_COLOR_PREDICATE.test(data.get(HAIR_COLOR));
    }

    private boolean validEyeColor() {
        return List.of("amb", "blu", "brn", "gry", "grn", "hzl", "oth").contains(data.get(EYE_COLOR));
    }

    private boolean validPassportId() {
        return PASSPORT_ID_PREDICATE.test(data.get(PASSPORT_ID));
    }


    public Optional<Integer> getBirthYear() {
        return Optional.ofNullable(data.get(BIRTH_YEAR)).map(Integer::parseInt);
    }

    public Optional<Integer> getIssueYear() {
        return Optional.ofNullable(data.get(ISSUE_YEAR)).map(Integer::parseInt);
    }

    public Optional<Integer> getExpirationYear() {
        return Optional.ofNullable(data.get(EXPIRATION_YEAR)).map(Integer::parseInt);
    }


}
