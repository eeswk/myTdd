package chap10;

public class ChangeUserService {
    private UserRepository userRepository;

    public ChangeUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void changeAddress(String id, Address address) {
        User user = userRepository.findById(id);
        if (user == null)
            throw new UserNotFoundException();

        user.changeAddress(address);
        userRepository.save(user);
    }

    public void changePw(String id, String pw, String newpw) {
        User user = userRepository.findById(id);
        if (user == null)
            throw new UserNotFoundException();
        if (!user.matchPassword(pw)) {
            throw new IdPwNotMatchException();
        }
        user.changePw(newpw);
        userRepository.save(user);
    }
}
