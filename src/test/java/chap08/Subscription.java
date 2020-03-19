package chap08;

import java.time.LocalDate;

public class Subscription {
    private String productId;
    private LocalDate date;
    private Grade grade;

    public Subscription(LocalDate date, Grade grade) {
        this.date = date;
        this.grade = grade;

    }

    public boolean isFinished(LocalDate now) {
        return now.isAfter(date);
    }

    public Grade getGrade() {
        return grade;
    }

    public String getProductId() {
        return productId;
    }
}
