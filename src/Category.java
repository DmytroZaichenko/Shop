
public enum Category {

    ALCOHOL(0),AQUA(1),BAKERY(2),DAIRY(3);

    private int id;

    private Category(int id) {
        this.id = id;
    }

    public int getValue() {
        return id;
    }

}
