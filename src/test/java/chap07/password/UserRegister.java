package chap07.password;

public class UserRegister {
    private WeakPasswordChecker passwordChecker;
    private UserRepository repository;

    public UserRegister(WeakPasswordChecker passwordChecker, UserRepository repository) {
        this.passwordChecker = passwordChecker;
        this.repository = repository;
    }

    public void register(String id, String pw, String email) {
        if (passwordChecker.checkerPasswordWeak(pw)) {
            throw new WeakPasswordException();
        }
        User user = repository.findById(id);
        if (user != null) {
            throw new DupIdException();
        }
        repository.save(new User(id, pw, email));
    }
}
