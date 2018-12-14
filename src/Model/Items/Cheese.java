package Model.Items;

public class Cheese extends Item {

    private final int buyCost = 5000;
    private final int saleCost = 2500;

    public Cheese(int x, int y, String ID) {
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
