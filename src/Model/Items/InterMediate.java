package Model.Items;

public class InterMediate extends Item {

    private final int buyCost = 4000;
    private final int saleCost = 2000;

    public InterMediate(int x, int y, String ID) {
        super(x, y, ID);
        this.setVolume(4);
    }

    public int getBuyCost() {
        return buyCost;
    }

    public int getSaleCost() {
        return saleCost;
    }
}
