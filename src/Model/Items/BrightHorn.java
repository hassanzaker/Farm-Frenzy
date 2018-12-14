package Model.Items;

public class BrightHorn extends Item {

    private final int buyCost = 3000;
    private final int saleCost = 1500;

    public BrightHorn(int x, int y, String ID) {
        super(x, y, ID);
        this.setVolume(5);
    }

    public int getBuyCost() {
        return buyCost;
    }

    public int getSaleCost() {
        return saleCost;
    }
}
