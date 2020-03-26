package chap10;

public class Score {
    private int strkes;
    private int balls;

    public Score(int strkes, int balls ) {
        this.strkes = strkes;
        this.balls = balls;
    }

    public int strike() {
        return this.strkes;
    }

    public int balls() {
        return this.balls;
    }

}
