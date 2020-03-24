package chap10;

public class User {
    private String id;
    private String password;

    private Address address;

    public User(String id, String password, Address address) {
        this.id = id;
        this.password = password;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public Address getAddress() {
        return address;
    }

    public void changeAddress(Address address) {
        this.address = address;
    }

    public void changePw(String pw) {
        this.password = pw;
    }

    public boolean matchPassword(String newpw) {
        return this.password == newpw;
    }
}
