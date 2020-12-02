package advent.of.code.day02;

public enum PasswordPolicyStrategy {
    ONE {
        @Override
        PasswordPolicy create(String policy) {
            return new PasswordPolicy1(policy);
        }
    },
    TWO {
        @Override
        PasswordPolicy create(String policy) {
            return new PasswordPolicy2(policy);
        }
    };

    abstract PasswordPolicy create(String policy);
}
