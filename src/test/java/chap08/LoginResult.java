package chap08;

public class LoginResult {
    private Result result;

    public LoginResult(Result result) {
        this.result = result;
    }

    public static LoginResult result(Result result) {
        return new LoginResult(result);
    }

    public static LoginResult authenticated(Customer c) {
        return result(Result.SUCCESS);
    }

    public static LoginResult fail(int resp) {
        return result(Result.FAIL);
    }

    public static LoginResult badAuthKey() {
        return result(Result.BAD);
    }
}
