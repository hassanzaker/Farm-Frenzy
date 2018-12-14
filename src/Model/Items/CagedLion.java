package Model.Items;

public class CagedLion extends Item {

    private final int buyCost = 150;
    private final int saleCost = 150;

    public CagedLion(int x, int y, String ID) {
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
