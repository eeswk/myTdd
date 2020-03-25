package chap10;

import java.time.LocalDateTime;

public class Member {
    private LocalDateTime expiryDate;

    public Member(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Member() {
    }

    public boolean isExpried() {
        //return expiryDate.isBefore(LocalDateTime.now());
        return expiryDate.isBefore(BizClock.now());
    }

    public boolean passedExpiredDate(LocalDateTime time) {
        return expiryDate.isBefore(time);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Member data = new Member();

        public Builder expiryDate(LocalDateTime expiryDate) {
            data.expiryDate = expiryDate;
            return this;
        }

        public Member build() {
            return data;
        }
    }
}
