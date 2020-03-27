package chap10.survey;

public class Item {
    private int number;
    private String desc;

    private Item(int number, String desc) {
        this.number = number;
        this.desc = desc;
    }

    public static Item of(int number, String desc) {
        return new Item(number, desc);
    }
}
