package advent.of.code.day04;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class PassportLineTest {

    @Test
    public void shouldParseValidLine() {
        PassportLine line = new PassportLine("ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm");

        assertThat(line.isValid()).isTrue();
    }

    @Test
    public void shouldParseValidLineWithMissingCid() {
        PassportLine line = new PassportLine("hcl:#ae17e1 iyr:2013 eyr:2024 ecl:brn pid:760753108 byr:1931 hgt:179cm");

        assertThat(line.isValid()).isTrue();
    }

    @Test
    public void shouldParseInvalidLine() {
        PassportLine line = new PassportLine("iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884 hcl:#cfa07d byr:1929");

        assertThat(line.isValid()).isFalse();
    }

    @Test
    public void shouldParseAnotherInvalidLine() {
        PassportLine line = new PassportLine("hcl:#cfa07d eyr:2025 pid:166559648 iyr:2011 ecl:brn hgt:59in");

        assertThat(line.isValid()).isFalse();
    }

}
