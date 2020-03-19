package chap08;

public class AuthService {
    private String authkey = "someKey";

    public int authenticate(String id, String pw) {
        boolean authorized = AuthUtil.authorize(authkey);
        if (authorized) {
            return AuthUtil.authenticate(id, pw);
        } else {
            return -1;
        }
    }
}
