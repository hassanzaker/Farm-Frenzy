package Model.Items;

public class CagesBear extends Item {

    private final int buyCost = 80;
    private final int saleCost = 80;

    public CagesBear(int x, int y, String ID) {
        super(x, y, ID);
        this.setVolume(20);
    }

    public int getBuyCost() {
        return buyCost;
    }

    public int getSaleCost() {
        return saleCost;
    }
}
