package chap10;

public class Address {
    private String area;
    private String location;

    public Address(String area, String location) {
        this.area = area;
        this.location = location;
    }

    public String getArea() {
        return area;
    }

    public String getLocation() {
        return location;
    }
}
