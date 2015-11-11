
public enum Category {

    NONE(0),ALCOHOL(1),AQUA(2),BAKERY(3),DAIRY(4);

    private int id;

    private Category(int id) {
        this.id = id;
    }

    public int getValue() {
        return id;
    }

}
