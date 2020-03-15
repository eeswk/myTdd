package chap07;

import java.time.LocalDateTime;

public class AutoDebitInfo {
    private String userId;
    private String cardNumber;
    private LocalDateTime regDate;

    public AutoDebitInfo(String userId, String cardNumber, LocalDateTime regDate) {
        this.userId = userId;
        this.cardNumber = cardNumber;
        this.regDate = regDate;
    }

    public void changeCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getUsrId() {
        return userId;
    }
}
