package Model.Items;

public class CagedBear extends Item {

    private final int buyCost = 80;
    private final int saleCost = 80;

    public CagedBear(int x, int y, String ID) {
        super(x, y, ID);
        this.setVolume(20);
        this.type="CagedBear";
    }

    public int getBuyCost() {
        return buyCost;
    }

    public int getSaleCost() {
        return saleCost;
    }
}