package chap03;

import java.time.LocalDate;

public class ExpiryDateCalculator {
    public LocalDate calculateExpireDate(LocalDate billingDate, int payAmount) {
        return billingDate.plusMonths(1);
    }
}
