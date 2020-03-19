package chap08;

public class AuthUtil {
    public static boolean authorize(String authkey) {
        return authkey.equals("someKey");
    }

    public static int authenticate(String id, String pw) {
        if (id.equals("id") && pw.equals("pw")) {
            return 1;
        } else {
            return -1;
        }
    }
}
