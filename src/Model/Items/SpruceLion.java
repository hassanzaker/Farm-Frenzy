package Model.Items;

public class SpruceLion extends Item {

    private final int buyCost = 2500;
    private final int saleCost = 7000;

    public SpruceLion(int x, int y, String ID) {
        super(x, y, ID);
        this.setVolume(25);
    }

    public int getBuyCost() {
        return buyCost;
    }

    public int getSaleCost() {
        return saleCost;
    }
}
