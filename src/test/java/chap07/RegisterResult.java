package chap07;

public class RegisterResult {

    private CardValidity cardValidity;

    public RegisterResult(CardValidity cardValidity) {
        this.cardValidity = cardValidity;
    }

    public static RegisterResult error(CardValidity validity) {
        return new RegisterResult(validity);
    }

    public static RegisterResult success() {
        return new RegisterResult(CardValidity.VALID);
    }

    public CardValidity getValidity() {
        return cardValidity;
    }
}
