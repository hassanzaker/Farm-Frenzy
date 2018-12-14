package Model.Items;

public class SourCream extends Item {

    private final int buyCost = 3000;
    private final int saleCost = 1500;

    public SourCream(int x, int y, String ID) {
        super(x, y, ID);
        this.setVolume(8);
    }

    public int getBuyCost() {
        return buyCost;
    }

    public int getSaleCost() {
        return saleCost;
    }
}
