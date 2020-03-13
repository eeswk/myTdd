package chap03;

import java.time.LocalDate;
import java.time.YearMonth;

public class ExpiryDateCalculator {

    private int anInt;
    private int dayOfFirstBilling;
    private boolean aBoolean;

    public LocalDate calculateExpireDate(LocalDate billingDate, int payAmount) {
        return billingDate.plusMonths(1);
    }
    public LocalDate calculateExpireDate(PayData payData) {
        int payAmount = payData.getPayAmount();
        int addedYears = payAmount / 100_000;
        int addedMonths = addedYears > 0 ?
                (12 * addedYears) + ((payAmount % 100_000) / 10_000) : payData.getPayAmount() / 10_000;
        //int addedMonths = payData.getPayAmount() == 100_000 ? 12 :  payData.getPayAmount() / 10_000;
        if (payData.getFirstBillingDate() != null) {
            return expiryDateUsingFirstBillingDate(payData, addedMonths);
        } else {
            if (isSameLengthOfMonth(payData.getBillingDate())) {
                LocalDate expirDate = payData.getBillingDate().plusMonths(addedMonths);
                return expirDate.withDayOfMonth(expirDate.lengthOfMonth());
            }
            return payData.getBillingDate().plusMonths(addedMonths);
        }
    }

    private boolean isSameLengthOfMonth(LocalDate payDate) {
        return payDate.getDayOfMonth() == payDate.lengthOfMonth();
    }

    private LocalDate expiryDateUsingFirstBillingDate(PayData payData, int addedMonths) {
        LocalDate candidateExp = payData.getBillingDate().plusMonths(addedMonths);
        if (!isSameDayOfMonth(candidateExp, payData.getFirstBillingDate())) {

            final int dayOfFirstBilling = payData.getFirstBillingDate().getDayOfMonth();
            final int dayLenOfCandiMon = lastDyOfMonth(candidateExp);

            if (isSameLengthOfMonth(payData.getFirstBillingDate())) {
                return candidateExp.withDayOfMonth(candidateExp.lengthOfMonth());
            }
            if (dayLenOfCandiMon <= dayOfFirstBilling) {
                return candidateExp.withDayOfMonth(dayLenOfCandiMon);
            }
            if (dayOfFirstBilling < candidateExp.getDayOfMonth()) {
                return candidateExp;
            }
            return candidateExp.withDayOfMonth(dayOfFirstBilling);
        } else {
            return candidateExp;
        }

    }

    private int lastDyOfMonth(LocalDate candidateExp) {
        return YearMonth.from(candidateExp).lengthOfMonth();
    }

    private boolean isSameDayOfMonth(LocalDate candidateExp, LocalDate dayOfFirstBilling) {
        //System.out.println(candidateExp.getDayOfMonth());
        //System.out.println(dayOfFirstBilling.getDayOfMonth());
        return dayOfFirstBilling.getDayOfMonth() == candidateExp.getDayOfMonth();
    }

}
