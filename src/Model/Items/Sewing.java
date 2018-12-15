package Model.Items;

public class Sewing extends Item {

    private final int buyCost = 300;
    private final int saleCost = 150;

    public Sewing(int x, int y, String ID) {
        super(x, y, ID);
        this.setVolume(3);
        this.type="Sewing";
    }

    public int getBuyCost() {
        return buyCost;
    }

    public int getSaleCost() {
        return saleCost;
    }
}
