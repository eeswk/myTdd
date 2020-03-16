package chap07.password;

public class StubWeakPasswordChecker implements WeakPasswordChecker{
    private boolean weak;

    public void setWeak(boolean weak) {
        this.weak = weak;
    }

    @Override
    public boolean checkerPasswordWeak(String pw) {
        return weak;
    }
}
