package Model.Items;

public class Cookie extends Item {

    private final int buyCost = 200;
    private final int saleCost = 100;

    public Cookie(int x, int y, String ID,Boolean inGrounad) {
        super(x, y, ID, inGrounad);
        this.setVolume(5);
        this.type="Cookie";
    }

    public int getBuyCost() {
        return buyCost;
    }

    public int getSaleCost() {
        return saleCost;
    }
}
