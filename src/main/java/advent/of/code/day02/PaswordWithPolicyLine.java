package advent.of.code.day02;

public class PaswordWithPolicyLine {

    private final PasswordPolicy passwordPolicy;
    private final String password;

    public PaswordWithPolicyLine(String line, PasswordPolicyStrategy strategy) {
        String[] parts = line.split(":");
        this.passwordPolicy = strategy.create(parts[0]);
        this.password = parts[1].trim();
    }

    public boolean isValid() {
        return this.passwordPolicy.isValid(this.password);
    }
}
