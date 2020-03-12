package chap02;

public class PasswordStengthMeter {
    public PasswordStength meter(String password) {
        if (password == null || password.isEmpty()) return PasswordStength.INVALID;


        /*
        if (password.length() < 8) {
            return PasswordStength.NORMAL;
        }
        */

        /* 조건문에 같이 넣기
        boolean lengthEnough = password.length() >= 8;
        boolean containsNumber = meetsContainingNumberCriteria(password);
        boolean containsUpper = meetsContainingUppercaseCriteria(password);

        if (lengthEnough) metCounts++;
        if (containsNumber) metCounts++;
        if (containsUpper) metCounts++;
        */

        /* 중복되니 계산 메서드로 추출
        if (password.length() >= 8) metCounts++;
        if (meetsContainingNumberCriteria(password)) metCounts++;
        if (meetsContainingUppercaseCriteria(password)) metCounts++;
         */
        int metCounts = getMetCriteriaCounts(password);

        /* 중복
        if (lengthEnough && !containsNumber && !containsUpper) {
            return PasswordStength.WEAK;
        }
        if (!lengthEnough && containsNumber && !containsUpper) {
            return PasswordStength.WEAK;
        }
        if (!lengthEnough && !containsNumber && containsUpper) {
            return PasswordStength.WEAK;
        }
         */
        if (metCounts <= 1) return PasswordStength.WEAK;

        /* 위에와 비슷한 조건
        if (!lengthEnough) {
            return PasswordStength.NORMAL;
        }

        if (!containsNumber) return PasswordStength.NORMAL;
        if (!containsUpper) return PasswordStength.NORMAL;
        */
        if (metCounts == 2) return PasswordStength.NORMAL;

        return PasswordStength.STRONG;



    }

    private int getMetCriteriaCounts(String password) {
        int metCounts = 0;
        if (password.length() >= 8) metCounts++;
        if (meetsContainingNumberCriteria(password)) metCounts++;
        if (meetsContainingUppercaseCriteria(password)) metCounts++;
        return metCounts;
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
