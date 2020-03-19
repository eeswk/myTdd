package chap08;

import java.time.LocalDate;

public class SubscriptionDao {
    public Subscription selectByUser(String id) {
        return new Subscription(LocalDate.now(), Grade.GOLD);
    }
}
