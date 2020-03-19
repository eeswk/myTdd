package chap09;

import org.springframework.stereotype.Component;

@Component
public class SimpleWeakPasswordChecker implements WeakPasswordChecker {
    @Override
    public boolean checkPasswordWeak(String pw) {
        return pw == null || pw.length() < 5;
    }
}
