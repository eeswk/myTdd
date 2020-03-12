package chap03;

import java.time.LocalDate;

public class ExpiryDateCalculator {
    public LocalDate calculateExpireDate(LocalDate billingDate, int payAmount) {
        return billingDate.plusMonths(1);
    }
    public LocalDate calculateExpireDate(PayData payData) {
        if (payData.getFirstBillingDate() != null) {
            LocalDate candidateExp = payData.getBillingDate().plusMonths(1);
            if (payData.getFirstBillingDate().getDayOfMonth() != candidateExp.getDayOfMonth()) {
                return candidateExp.withDayOfMonth(payData.getFirstBillingDate().getDayOfMonth());
            }

            /*
            if (payData.getFirstBillingDate().equals(LocalDate.of(2020, 01, 31))) {
                return LocalDate.of(2020, 03, 31);
            }
             */
        }
        return payData.getBillingDate().plusMonths(1);
    }
}
