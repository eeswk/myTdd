package tdd.money;

public interface Expression {
    //Money reduce(String currency);

    Money reduce(Bank bank, String to);

    Expression plus(Expression addend);

    Expression times(int multipier);
}
