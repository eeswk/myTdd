package chap02;

public class PasswordStengthMeter {
    public PasswordStength meter(String password) {
        if (password == null || password.isEmpty()) return PasswordStength.INVALID;
        boolean lengthEnough = password.length() >= 8;
        /*
        if (password.length() < 8) {
            return PasswordStength.NORMAL;
        }
        */
        boolean containsNumber = meetsContainingNumberCriteria(password);
        boolean containsUpper = meetsContainingUppercaseCriteria(password);

        if (lengthEnough && !containsNumber && !containsUpper) {
            return PasswordStength.WEAK;
        }
        if (!lengthEnough && containsNumber && !containsUpper) {
            return PasswordStength.WEAK;
        }
        if (!lengthEnough && !containsNumber && containsUpper) {
            return PasswordStength.WEAK;
        }

        if (!lengthEnough) {
            return PasswordStength.NORMAL;
        }

        if (!containsNumber) return PasswordStength.NORMAL;
        if (!containsUpper) return PasswordStength.NORMAL;
        return PasswordStength.STRONG;

    }

    private boolean meetsContainingUppercaseCriteria(String password) {
        for (Character ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                return true;
            }
        }
        return false;
    }

    private boolean meetsContainingNumberCriteria(String password) {
        for (Character ch : password.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                return true;
            }
        }
        return false;
    }
}
